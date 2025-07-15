package com.jocata.CibilScore.service.impl;

import com.jocata.CibilScore.Form.*;
import com.jocata.CibilScore.dao.*;
import com.jocata.CibilScore.entity.*;
import com.jocata.CibilScore.service.CibilScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CibilScoreServiceImpl implements CibilScoreService {

    @Autowired
    private CreditReportsDao creditReportsDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private CibilScoreDao cibilScoreDao;

    @Autowired
    private AccountsDao accountsDao;

    @Autowired
    private EnquiriesDao enquiriesDao;

    @Autowired
    private RemarksDao remarksDao;



    @Override
    public CreditReportForm saveCibilScore(CreditReportForm form) {

        CreditReports creditReports =creditReportsDao.findCibilScore(form.getCustomer().getPan());
        if(creditReports!=null){
            AccountForm accountForm =form.getAccountsList().get(0);
            addAccounts(accountForm,creditReports);
            return form;
        }
        else {

            CreditReports entity = addReportDetails(String.valueOf(LocalDate.now()));
            Customer customer = addCustomerDetails(form.getCustomer(), entity);
            addAddress(form.getCustomer().getAddress(), customer);
            addCibilScore(form.getCibilScore(), entity);
            if (form.getAccountsList() != null) {
                for (AccountForm accountForm : form.getAccountsList()) {
                    addAccounts(accountForm, entity);
                }
            }
            if (form.getEnquiriesList() != null) {
                for (EnquiryForm enquiryForm : form.getEnquiriesList()) {
                    addEnquiries(enquiryForm, entity);
                }
            }
            if (form.getRemarksList() != null) {
                for (String remark : form.getRemarksList()) {
                    addRemarks(remark, entity);
                }
            }
        }
        return form;
    }

    @Override
    public CreditReportForm getCreditReportByPan(String pan) {
        CreditReports res = creditReportsDao.findCibilScore(pan);
        if(res == null) return null;

        CreditReportForm form = new CreditReportForm();
        form.setReportId(res.getReportId());
        form.setGeneratedOn(String.valueOf(res.getGeneratedOn()));
        setCustomerDetails(res.getCustomer(), form);
        setAddressDetails(res.getCustomer().getAddresses(), form);
        setCibilScoreDetails(res.getCibilScore(),form);
        setAccountDetails(res.getAccounts(),form);
        setEnquiyDetails(res.getEnquiries(),form);
        setRemarksDetails(res.getRemarks(),form);

        return form;

    }



    private void addRemarks(String remarksText,CreditReports reports) {
        Remarks entity = new Remarks();
        entity.setCreditReports(reports);
        entity.setDescription(remarksText);
        remarksDao.saveRemark(entity);
    }


    private void addEnquiries(EnquiryForm form,CreditReports reports) {
        Enquiries entity = new Enquiries();
        entity.setCreditReports(reports);
        entity.setEnquiryDate(form.getEnquiryDate());
        entity.setMemberName(form.getMemberName());
        entity.setEnquiryPurpose(form.getEnquiryPurpose());
        entity.setEnquiryAmount(BigDecimal.valueOf(form.getEnquiryAmount()));
        enquiriesDao.saveEnquiry(entity);
    }

    private void addAccounts(AccountForm form,CreditReports reports) {

        Accounts entity = new Accounts();
        entity.setCreditReports(reports);
        entity.setAccountNumber(form.getAccountNumber());
        entity.setAccountType(form.getAccountType());
        entity.setMemberName(form.getMemberName());
        entity.setOwnerShip(form.getOwnerShip());
        entity.setDateOpened(form.getDateOpened());
        entity.setLastPaymentDate(form.getLastPaymentDate());
        entity.setCurrentBalance(BigDecimal.valueOf(form.getCurrentBalance()));
        entity.setCreditLimit(BigDecimal.valueOf(form.getCreditLimit()));
        entity.setSanctionedAmount(BigDecimal.valueOf(form.getSanctionedAmount()));
        entity.setEmiAmount(BigDecimal.valueOf(form.getEmiAmount()));
        entity.setTenureMonths(form.getTenureMonths());
        entity.setPaymentHistory(form.getPaymentHistory());
        entity.setAccountStatus(form.getAccountStatus());
        accountsDao.saveAccount(entity);
    }

    private void addCibilScore(CibilScoreForm form, CreditReports reports) {
        CibilScore entity = new CibilScore();
        entity.setCreditReports(reports);
        entity.setScore(form.getScore() != null ? form.getScore() : null);
        entity.setScoreDate(form.getScoreDate() != null ? form.getScoreDate() : null);
        entity.setRiskGrade(form.getRiskGrade() != null ? form.getRiskGrade() : null);

        cibilScoreDao.saveCibilScore(entity);
    }


    private void addAddress(AddressForm form,Customer customer) {

        Addresses entity = new Addresses();
        entity.setCustomer(customer);
        entity.setLine(form.getLine());
        entity.setStreet(form.getStreet());
        entity.setCity(form.getCity());
        entity.setState(form.getState());
        entity.setPincode(Long.valueOf(form.getPincode()));
        addressDao.saveAddress(entity);
    }

    private Customer addCustomerDetails(CustomerForm form,CreditReports report) {

        Customer entity = new Customer();
        entity.setCreditReports(report);
        entity.setFullName(form.getFullName());
        entity.setDob(form.getDob());
        entity.setGender(form.getGender());
        entity.setPan(form.getPan());
        entity.setMobile(Long.valueOf(form.getMobile()));
        entity.setEmail(form.getEmail());
        entity.setAadhar(Long.valueOf(form.getAadhar()));
        return customerDao.saveCustomer(entity);

    }

    private CreditReports addReportDetails(String generatedOn) {

        CreditReports entity = new CreditReports();
        entity.setGeneratedOn(Date.valueOf(generatedOn));
        return creditReportsDao.saveCreditReport(entity);
    }


    private void setRemarksDetails(List<Remarks> remarks, CreditReportForm form) {
        if (remarks != null && !remarks.isEmpty()) {
            List<String> remarksList = new ArrayList<>();
            for (Remarks r : remarks) {
                remarksList.add(r.getDescription());
            }
            form.setRemarksList(remarksList);
        }
    }

    private void setEnquiyDetails(List<Enquiries> enquiries, CreditReportForm form) {

        if (enquiries != null && !enquiries.isEmpty()) {
            List<EnquiryForm> enquiryForms = new ArrayList<>();
            for (Enquiries e : enquiries) {
                EnquiryForm enqForm = new EnquiryForm();
                enqForm.setEnquiryDate(e.getEnquiryDate());
                enqForm.setMemberName(e.getMemberName());
                enqForm.setEnquiryPurpose(e.getEnquiryPurpose());
                enqForm.setEnquiryAmount(e.getEnquiryAmount().doubleValue());
                enquiryForms.add(enqForm);
            }
            form.setEnquiriesList(enquiryForms);
        }

    }

    private void setAccountDetails(List<Accounts> accounts, CreditReportForm form) {

        if (accounts != null && !accounts.isEmpty()) {
            List<AccountForm> accountForms = new ArrayList<>();
            for (Accounts acc : accounts) {
                AccountForm accForm = new AccountForm();
                accForm.setAccountNumber(acc.getAccountNumber());
                accForm.setAccountType(acc.getAccountType());
                accForm.setMemberName(acc.getMemberName());
                accForm.setOwnerShip(acc.getOwnerShip());
                accForm.setDateOpened(acc.getDateOpened());
                accForm.setLastPaymentDate(acc.getLastPaymentDate());
                accForm.setCurrentBalance(acc.getCurrentBalance().doubleValue());
                accForm.setCreditLimit(acc.getCreditLimit().doubleValue());
                accForm.setSanctionedAmount(acc.getSanctionedAmount().doubleValue());
                accForm.setEmiAmount(acc.getEmiAmount().doubleValue());
                accForm.setTenureMonths(acc.getTenureMonths());
                accForm.setPaymentHistory(acc.getPaymentHistory());
                accForm.setAccountStatus(acc.getAccountStatus());
                accountForms.add(accForm);
            }
            form.setAccountsList(accountForms);
        }
    }

    private void setCibilScoreDetails(CibilScore score, CreditReportForm form) {

        CibilScoreForm csForm = new CibilScoreForm();
        csForm.setScore(score.getScore());
        csForm.setScoreDate(score.getScoreDate());
        csForm.setRiskGrade(score.getRiskGrade());
        form.setCibilScore(csForm);
    }

    private void setCustomerDetails(Customer customer, CreditReportForm form) {

        CustomerForm customerForm = new CustomerForm();
        customerForm.setFullName(customer.getFullName());
        customerForm.setDob(customer.getDob());
        customerForm.setGender(customer.getGender());
        customerForm.setPan(customer.getPan());
        customerForm.setMobile(String.valueOf(customer.getMobile()));
        customerForm.setEmail(customer.getEmail());
        customerForm.setAadhar(String.valueOf(customer.getAadhar()));
        form.setCustomer(customerForm);
    }

    private void setAddressDetails(Addresses address, CreditReportForm form) {

        AddressForm addressForm = new AddressForm();
        addressForm.setLine(address.getLine());
        addressForm.setStreet(address.getStreet());
        addressForm.setCity(address.getCity());
        addressForm.setState(address.getState());
        addressForm.setPincode(String.valueOf(address.getPincode()));
        form.getCustomer().setAddress(addressForm);
    }
}
