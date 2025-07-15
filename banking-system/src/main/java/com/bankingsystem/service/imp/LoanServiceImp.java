package com.bankingsystem.service.imp;

import com.bankingsystem.dao.LoanDao;
import com.bankingsystem.dao.imp.LoanDaoImp;
import com.bankingsystem.entity.LoanEntity;
import com.bankingsystem.entity.LoanResponseEntity;
import com.bankingsystem.form.LoanCustomerForm;
import com.bankingsystem.form.LoanForm;
import com.bankingsystem.form.LoanTypeForm;
import com.bankingsystem.service.LoanCustomerService;
import com.bankingsystem.service.LoanService;
import com.bankingsystem.service.LoanTypeService;

import java.util.List;
import java.util.Scanner;

public class LoanServiceImp implements LoanService {

    private final LoanDao dao = new LoanDaoImp();
    Scanner sc = new Scanner(System.in);
    LoanEntity entity = new LoanEntity();

    @Override
    public String addLoan(LoanForm form) {
        LoanCustomerService service = new LoanCustomerServiceImp();
        LoanTypeService typeService = new LoanTypeServiceImp();
        String values = null;
        LoanTypeForm typeForm;
        if(form.getCustomerID()!=null&& service.getCustomer(form.getCustomerID())!=null){

            entity.setCustomerID(form.getCustomerID());
            entity.setLoanTypeId(form.getLoanTypeId());
            entity.setBranchId(form.getBranchId());
            entity.setStatusId(form.getStatusId());
            entity.setPrincipalAmount(form.getPrincipalAmount());
            typeForm = typeService.getLoanType(form.getLoanTypeId());
            entity.setIntrestRate(Float.valueOf(typeForm.getIntrestRate()));
            entity.setTermMonths(form.getTermMonths());

           return  dao.addLoan(entity);
        }
        else{
            System.out.println("No Customer Found Do You want to create the Customer YES/NO");
            values =sc.nextLine();
        }
        if("yes".equalsIgnoreCase(values)){
            LoanCustomerForm customerForm = new LoanCustomerForm();
            LoanCustomerService customerService = new LoanCustomerServiceImp();

            System.out.println("Enter the Customer Name");
            customerForm.setName(sc.nextLine());
            System.out.println("Enter the customer email");
            customerForm.setEmail(sc.nextLine());
            System.out.println("Enter the customer phone ");
            customerForm.setPhone(sc.nextLine());
            System.out.println("Enter the customer address");
            customerForm.setAddress(sc.nextLine());
            System.out.println("Enter the customer dob");
            customerForm.setDob(sc.nextLine());
            Integer id =customerService.addCustomer(customerForm);
            entity.setCustomerID(id);
            entity.setLoanTypeId(form.getLoanTypeId());
            entity.setBranchId(form.getBranchId());
            entity.setStatusId(form.getStatusId());
            entity.setPrincipalAmount(form.getPrincipalAmount());
            typeForm=typeService.getLoanType(form.getLoanTypeId());
            entity.setIntrestRate(Float.valueOf(typeForm.getIntrestRate()));
            return dao.addLoan(entity);
        }
        else{
            System.exit(0);
        }
        return " Customer Not Found";
    }

    public void getAllLoans(){

        List<LoanResponseEntity> listEntity = dao.getAllLaons();
        for(LoanResponseEntity responseEntity : listEntity){
            System.out.println(responseEntity.getLoanId()+"     "+responseEntity.getCustomerName()+"    "+responseEntity.getLoanType()+"    "+responseEntity.getBranchType()+"     "+responseEntity.getStatusName()+"      "+responseEntity.getPrincipalAmount()+"      "+responseEntity.getIntrestRate()+"     "+responseEntity.getTermMonths()+"      "+responseEntity.getStartDate()+"       "+responseEntity.getEndDate());
        }
    }

    public void getLoan(Integer loanId){
        LoanResponseEntity responseEntity = dao.getLoan(loanId );
        System.out.println(responseEntity.getLoanId()+"     "+responseEntity.getCustomerName()+"        "+responseEntity.getLoanType()+"    "+responseEntity.getBranchType()+"     "+responseEntity.getStatusName()+"      "+responseEntity.getPrincipalAmount()+"      "+responseEntity.getIntrestRate()+"     "+responseEntity.getTermMonths()+"      "+responseEntity.getStartDate()+"       "+responseEntity.getEndDate());
    }

    @Override
    public void updateLoan(LoanForm form) {
        entity.setLoanId(form.getLoanId());
        entity.setStatusId(form.getStatusId());
        entity.setTermMonths(form.getTermMonths());
        entity.setStartDate(form.getStartDate());
        entity.setEndDate(form.getEndDate());
        System.out.println(dao.updateLoan(entity));
    }


    public void deleteLoan(Integer id){
        System.out.println(dao.deleteLoan(id));
    }

    public String approveLoan(Integer loanID){
        return  dao.approveLoan(loanID);
    }

}
