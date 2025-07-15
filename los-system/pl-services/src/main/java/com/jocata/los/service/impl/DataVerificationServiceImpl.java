package com.jocata.los.service.impl;

import com.jocata.los.dao.*;
import com.jocata.los.entity.*;
import com.jocata.los.response.*;
import com.jocata.los.service.AadharService;
import com.jocata.los.service.CibilScoreService;
import com.jocata.los.service.DataVerificationService;
import com.jocata.los.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class DataVerificationServiceImpl implements DataVerificationService {

    @Autowired
    LoanDetailsDao loanDetailsDao;

    @Autowired
    AadharService aadharService;

    @Autowired
    PanService panService;

    @Autowired
    CibilScoreService cibilScoreService;

    @Autowired
    AadharDao aadharDao;

    @Autowired
    PanDetailsDao panDetailsDao;

    @Autowired
    CibilScoreDao cibilScoreDao;


    @Override
    @Transactional
    public String getCustomerData(String loanAppId) {
        LoanApplications loan = loanDetailsDao.getLoan(Integer.parseInt(loanAppId));

       PanResponseForm panResponseForm= panService.getPanServiceByPanNumber(loan.getCustomer().getPan());
        AadharResponseForm aadharResponseForm =aadharService.getAadharByAadharNumber(loan.getCustomer().getAadhar());
       CibilScoreResponseForm cibilScoreResponseForm= cibilScoreService.getCibilScoreByPan(loan.getCustomer().getPan());

       if(panResponseForm!=null && aadharResponseForm!=null && cibilScoreResponseForm!=null){
           setAadharDetails(aadharResponseForm,loan.getCustomer());
           setPanDetails(panResponseForm,loan.getCustomer());
           setCibilScore(cibilScoreResponseForm,loan.getCustomer());
           return "Verification Successes";

       }
       return "Verification Failed";


    }


    private void setAadharDetails(AadharResponseForm form, Customers customer){

        AadharDetails entity = new AadharDetails();
        entity.setCustomer(customer);
        entity.setAadharNumber(form.getNumber());
        entity.setName(form.getName());
        entity.setGender(form.getGender());
        entity.setDob(Date.valueOf(form.getDob()));
        entity.setFatherName(form.getFatherName());
        entity.setStreet(form.getAddress().getStreet());
        entity.setCity(form.getAddress().getCity());
        entity.setState(form.getAddress().getState());
        entity.setPincode(form.getAddress().getPincode());
        aadharDao.addAadhar(entity);

    }


    private void setPanDetails(PanResponseForm form,Customers customer){

        PanDetails entity = new PanDetails();
        entity.setCustomer(customer);
        entity.setPanNumber(form.getPanNumber());
        entity.setFullName(form.getFullName());
        entity.setDob(Date.valueOf(form.getDob()));
        entity.setFatherName(form.getFatherName());
        entity.setStatus(form.getStatus());
        entity.setIssuedOn(Date.valueOf(form.getIssuedOn()));
        entity.setGender(form.getGender());
        entity.setCategory(form.getCategory());
        entity.setAddress(form.getAddress());
        panDetailsDao.addPanDetails(entity);
    }

    private void setCibilScore(CibilScoreResponseForm form,Customers customer){

        CibilScoreDetails entity = new CibilScoreDetails();
        entity.setCustomer(customer);
        entity.setCibilScore(form.getCibilScoreForm().getScore());
        Integer score = form.getCibilScoreForm().getScore();
        if (score > 750) {
            entity.setCreditStatus("GOOD");
        } else if (score > 720) {
            entity.setCreditStatus("AVERAGE");
        } else {
            entity.setCreditStatus("POOR");
        }
        List<EnquiryForm> enquiries =form.getEnquiryForms();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,-3);
        java.util.Date date=cal.getTime();

        Integer enquiryCount=0;
        for(EnquiryForm enquiryForm:enquiries){
            if(enquiryForm.getEnquiryDate()!=null && enquiryForm.getEnquiryDate().after(date)){
                enquiryCount++;
            }
        }
        entity.setNoOfEnquiry(enquiryCount);
        Integer count=0;
        Double totalAmount=0.0;
        Double totalEmis=0.0;
        for(AccountForm accountForm:form.getAccountFormList()){
            totalAmount+=accountForm.getCurrentBalance();
            if(accountForm.getAccountStatus().equals("Active")) {
                count++;
                totalEmis+=accountForm.getEmiAmount();
            }
        }
        entity.setNoOfActiveAccounts(count);
        entity.setLoanOutstanding(String.valueOf(totalAmount));
        entity.setEmisTotal(BigDecimal.valueOf(totalEmis));

        cibilScoreDao.addCibilScore(entity);
    }
}
