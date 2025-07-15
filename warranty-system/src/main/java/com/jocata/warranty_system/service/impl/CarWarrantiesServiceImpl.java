package com.jocata.warranty_system.service.impl;

import com.jocata.warranty_system.Dao.CarSaleRecordsDao;
import com.jocata.warranty_system.Dao.CarWarrantiesDao;
import com.jocata.warranty_system.Dao.WarrantyPlansDao;
import com.jocata.warranty_system.entity.CarWarranties;
import com.jocata.warranty_system.entity.WarrantyPlans;
import com.jocata.warranty_system.form.CarWarrantiesReqForm;
import com.jocata.warranty_system.form.CarWarrantiesResForm;
import com.jocata.warranty_system.service.CarWarrantiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarWarrantiesServiceImpl implements CarWarrantiesService {

    @Autowired
    private CarWarrantiesDao dao;

    @Autowired
    private CarSaleRecordsDao carSaleRecordsDao;

    @Autowired
    private WarrantyPlansDao warrantyPlansDao;


    private String validateExistingWarranty(String id, Integer km, Integer planId) {
        List<CarWarranties> list = dao.getCarWarranties(Integer.parseInt(id));
        if (list == null || list.isEmpty()) {
            return "null";
        }

        CarWarranties entity = list.getFirst();
        LocalDate date = LocalDate.now();

        if (planId > entity.getPlans().getPlanId()) {
            boolean isKmValid = entity.getBwKmEnd() != null && km < entity.getBwKmEnd();
            boolean isDateValid = entity.getBwEndDate() != null && entity.getBwEndDate().toLocalDate().isAfter(date);

            if (isKmValid && isDateValid) {
                return "new";
            } else {
                return "used";
            }
        }

        return "plan";
    }





    @Override
    public List<CarWarrantiesResForm> getCarWarranties(String id) {
        List<CarWarrantiesResForm> resForms = new ArrayList<>();
        List<CarWarranties> entities = dao.getCarWarranties(Integer.parseInt(id));
        for(CarWarranties entity:entities){
            resForms.add(entityToForm(entity));
        }
        return resForms;
    }
    @Override
    public CarWarrantiesResForm addCarWarranties(CarWarrantiesReqForm form) {
        CarWarrantiesResForm resForm;

        WarrantyPlans plan = warrantyPlansDao.getWarrantyPlans(Integer.parseInt(form.getPlanId()));

        if (plan == null) {
            resForm = entityToForm(formToEntity(form));
            resForm.setMessage("Plan not found");
            return resForm;
        }

        if ("1".equals(form.getPlanId())) {
            setBasicWarrantyFields(form, plan);
        } else {
            String res = validateExistingWarranty(
                    form.getCarSaleId(),
                    Integer.parseInt(form.getKmReading()),
                    Integer.parseInt(form.getPlanId())
            );

            switch (res) {
                case "new":
                    setExtendedWarrantyFields(form, plan);
                    break;

                case "used":
                    if (!plan.getCoverageType().getCoverageTypeId().equals(1)) {
                        setExtendedWarrantyFields(form, plan);
                    } else {
                        resForm = entityToForm(formToEntity(form));
                        resForm.setMessage("For Used Vehicles, Commercial is Not Possible");
                        return resForm;
                    }
                    break;

                default:
                    resForm = entityToForm(formToEntity(form));
                    resForm.setMessage("Invalid Plan ID You Can Not Choose Lesser Plans");
                    return resForm;
            }
        }

        return entityToForm(dao.addCarWarranties(formToEntity(form)));
    }


    private void setBasicWarrantyFields(CarWarrantiesReqForm form, WarrantyPlans plan) {
        LocalDate now = LocalDate.now();
        LocalDate bwEnd = now.plusMonths(plan.getDurationMonths());

        form.setBwStartDate(now.toString());
        form.setBwEndDate(bwEnd.toString());
        form.setBwKmStart("0");
        form.setBwKmEnd(String.valueOf(plan.getKmLimit()));

        form.setExwStartDate(null);
        form.setExwEndDate(null);
        form.setExwKmStart(null);
        form.setExwKmEnd(null);

        form.setPricePaid(String.valueOf(plan.getBasePrice()));
        form.setPurchasedDuringBasic("True");
        form.setIsActive(now.isBefore(bwEnd) || now.isEqual(bwEnd) ? "True" : "False");
    }

    private void setExtendedWarrantyFields(CarWarrantiesReqForm form, WarrantyPlans plan) {

        List<CarWarrantiesResForm> list = getCarWarranties(form.getCarSaleId());
        CarWarrantiesResForm existingWarranty = list.getFirst();

        form.setBwStartDate(null);
        form.setBwEndDate(null);
        form.setBwKmStart(null);
        form.setBwKmEnd(null);

        String exwStartDate;
        Integer kmStart;

        if (existingWarranty.getExwEndDate() != null) {
            exwStartDate = existingWarranty.getExwEndDate();
            kmStart = Integer.valueOf(existingWarranty.getExwKmEnd());
        } else {
            exwStartDate = existingWarranty.getBwEndDate();
            kmStart = Integer.valueOf(existingWarranty.getBwKmEnd());
        }
        form.setExwStartDate(exwStartDate);


        LocalDate startDate = LocalDate.parse(exwStartDate);
        LocalDate exwEnd = startDate.plusMonths(plan.getDurationMonths());
        form.setExwEndDate(exwEnd.toString());
        form.setExwKmStart(String.valueOf(kmStart));
        form.setExwKmEnd(String.valueOf(kmStart + plan.getKmLimit()));


        int carTypeId = carSaleRecordsDao.getCarSaleRecords(Integer.parseInt(form.getCarSaleId()))
                .getCarTypeId()
                .getCarTypeId();

        BigDecimal price = calculatePricePaid(plan, carTypeId);
        for (CarWarrantiesResForm entity : list) {
            BigDecimal pricePaid = new BigDecimal(entity.getPricePaid());
            BigDecimal basePrice;
            BigDecimal surchargePercent = BigDecimal.ZERO;

            Integer carType = Integer.valueOf(entity.getCarSaleId()); // Use carTypeId, not carSaleId

            if (carType == 3)
            {
                basePrice = pricePaid;
            }
            else if (carType == 4)
            {
                basePrice = pricePaid.multiply(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP);
            }
            else if (carType == 5)
            {
                surchargePercent = warrantyPlansDao.getWarrantyPlans(Integer.valueOf(entity.getPlanId())).getSurchargePercent();
                if (surchargePercent == null) surchargePercent = BigDecimal.ZERO;

                BigDecimal divisor = BigDecimal.ONE.add(surchargePercent.divide(BigDecimal.valueOf(100)));
                basePrice = pricePaid.divide(divisor, 2, RoundingMode.HALF_UP);
            }
            else if (carType == 6) {
                surchargePercent = warrantyPlansDao.getWarrantyPlans(Integer.valueOf(entity.getPlanId())).getSurchargePercent();
                if (surchargePercent == null) surchargePercent = BigDecimal.ZERO;

                BigDecimal multiplier = BigDecimal.ONE.add(surchargePercent.divide(BigDecimal.valueOf(100)));
                basePrice = pricePaid.multiply(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(5).multiply(multiplier), 2, RoundingMode.HALF_UP);
            } else
            {
                basePrice = pricePaid;
            }

            price = price.subtract(basePrice);
        }

        form.setPricePaid(String.valueOf(price));
        form.setExwPurchaseDate(String.valueOf(LocalDate.now()));


        LocalDate currentDate = LocalDate.now();
        if(existingWarranty.getExwEndDate()!=null) {
            form.setPurchasedDuringBasic("False");
            if((currentDate.isAfter(LocalDate.parse(existingWarranty.getExwEndDate())) &&(currentDate.isBefore(exwEnd) || currentDate.isEqual(exwEnd)))){
                form.setIsActive("True");
            }
            else{
                form.setIsActive("False");
            }
        }
        else {
            LocalDate bwEnd = LocalDate.parse(existingWarranty.getBwEndDate());
            form.setPurchasedDuringBasic(currentDate.isBefore(bwEnd) ? "True" : "False");
            if (currentDate.isAfter(bwEnd) && (currentDate.isBefore(exwEnd) || currentDate.isEqual(exwEnd))) {
                form.setIsActive("True");
            } else {
                form.setIsActive("False");
            }
        }
    }

    private BigDecimal calculatePricePaid(WarrantyPlans plan, int carTypeId) {
        BigDecimal basePrice = plan.getBasePrice();
        BigDecimal surchargePercent = plan.getSurchargePercent() != null ? plan.getSurchargePercent() : BigDecimal.ZERO;

        if (carTypeId == 3) {
            return basePrice;
        } else if (carTypeId == 4) {
            return basePrice.multiply(BigDecimal.valueOf(2)).divide(BigDecimal.valueOf(100));
        } else if (carTypeId == 5) {
            return basePrice.add(basePrice.multiply(surchargePercent).divide(BigDecimal.valueOf(100)));
        } else if (carTypeId == 6) {
            BigDecimal total = basePrice.add(basePrice.multiply(surchargePercent).divide(BigDecimal.valueOf(100)));
            return total.multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(100));
        } else {
            return basePrice; // Default fallback
        }
    }
    private CarWarranties formToEntity(CarWarrantiesReqForm form) {
        CarWarranties entity = new CarWarranties();

        entity.setCarSales(carSaleRecordsDao.getCarSaleRecords(Integer.parseInt(form.getCarSaleId())));
        entity.setPlans(warrantyPlansDao.getWarrantyPlans(Integer.parseInt(form.getPlanId())));

        entity.setBwStartDate(form.getBwStartDate() == null ? null : Date.valueOf(form.getBwStartDate()));
        entity.setBwEndDate(form.getBwEndDate() == null ? null : Date.valueOf(form.getBwEndDate()));
        entity.setBwKmStart(form.getBwKmStart() == null ? null : Integer.parseInt(form.getBwKmStart()));
        entity.setBwKmEnd(form.getBwKmEnd() == null ? null : Integer.parseInt(form.getBwKmEnd()));

        entity.setExwStartDate(form.getExwStartDate() == null ? null : Date.valueOf(form.getExwStartDate()));
        entity.setExwEndDate(form.getExwEndDate() == null ? null : Date.valueOf(form.getExwEndDate()));
        entity.setExwKmStart(form.getExwKmStart() == null ? null : Integer.parseInt(form.getExwKmStart()));
        entity.setExwKmEnd(form.getExwKmEnd() == null ? null : Integer.parseInt(form.getExwKmEnd()));

        entity.setPricePaid(form.getPricePaid() == null ? null : new BigDecimal(form.getPricePaid()));
        entity.setPurchasedDuringBasic(Boolean.parseBoolean(form.getPurchasedDuringBasic()));
        entity.setExwPurchaseDate(form.getExwPurchaseDate() == null ? null : Date.valueOf(form.getExwPurchaseDate()));
        entity.setIsActive(Boolean.parseBoolean(form.getIsActive()));

        return entity;
    }

    private CarWarrantiesResForm entityToForm(CarWarranties entity) {
        CarWarrantiesResForm form = new CarWarrantiesResForm();

        form.setId(String.valueOf(entity.getCarWarrantyId()));
        form.setCarSaleId(entity.getCarSales() == null ? null : String.valueOf(entity.getCarSales().getCarTypeId().getCarTypeId()));
        form.setPlanId(entity.getPlans() == null ? null : entity.getPlans().getPlanId().toString());

        form.setBwStartDate(entity.getBwStartDate() == null ? null : entity.getBwStartDate().toString());
        form.setBwEndDate(entity.getBwEndDate() == null ? null : entity.getBwEndDate().toString());
        form.setBwKmStart(entity.getBwKmStart() == null ? null : entity.getBwKmStart().toString());
        form.setBwKmEnd(entity.getBwKmEnd() == null ? null : entity.getBwKmEnd().toString());

        form.setExwStartDate(entity.getExwStartDate() == null ? null : entity.getExwStartDate().toString());
        form.setExwEndDate(entity.getExwEndDate() == null ? null : entity.getExwEndDate().toString());
        form.setExwKmStart(entity.getExwKmStart() == null ? null : entity.getExwKmStart().toString());
        form.setExwKmEnd(entity.getExwKmEnd() == null ? null : entity.getExwKmEnd().toString());

        form.setPricePaid(entity.getPricePaid() == null ? null : entity.getPricePaid().toString());
        form.setPurchasedDuringBasic(String.valueOf(entity.getPurchasedDuringBasic()));
        form.setExwPurchaseDate(entity.getExwPurchaseDate() == null ? null : entity.getExwPurchaseDate().toString());
        form.setIsActive(String.valueOf(entity.getIsActive()));

        return form;
    }



}
