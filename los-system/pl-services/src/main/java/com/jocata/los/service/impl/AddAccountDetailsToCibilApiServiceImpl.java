package com.jocata.los.service.impl;

import com.jocata.los.EmiCalculator;
import com.jocata.los.dao.LoanDetailsDao;
import com.jocata.los.entity.LoanApplications;
import com.jocata.los.request.AddressForm;
import com.jocata.los.request.CreditReportForm;
import com.jocata.los.request.CustomerForm;
import com.jocata.los.response.AccountForm;
import com.jocata.los.service.AccountService;
import com.jocata.los.service.AddAccountDetailsToCibilApiService;
import com.jocata.los.service.LoanDisbursmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddAccountDetailsToCibilApiServiceImpl implements AddAccountDetailsToCibilApiService {

    @Autowired
    LoanDetailsDao loanDetailsDao;

    @Autowired
    LoanDisbursmentService service;

    @Autowired
    AccountService accountService;


    @Transactional
    @Override
    public CreditReportForm addAccountDetailsToCibilApi(String loanId) {
        LoanApplications loan =loanDetailsDao.getLoan(Integer.parseInt(loanId));
        List<EmiCalculator.EmiMonth> list = service.loanDisbursment(loanId);

        AccountForm accountForm = buildAccountForm(loanId,loan,list);
       CustomerForm customerForm= buildCustomerForm(loan);


        CreditReportForm creditReportForm = new CreditReportForm();
        creditReportForm.setGeneratedOn(String.valueOf(LocalDateTime.now()));
        creditReportForm.setAccountsList(List.of(accountForm));
        creditReportForm.setCustomer(customerForm);

        CreditReportForm response = accountService.addAccountDetails(creditReportForm);

        return response;

    }
    private AccountForm buildAccountForm(String loanId, LoanApplications loan, List<EmiCalculator.EmiMonth> emiList) {

        AccountForm form = new AccountForm();
        form.setAccountNumber(loanId);
        form.setAccountType(loan.getLoanType());
        form.setMemberName("BankOfBaroda");
        form.setOwnerShip("Individual");
        form.setDateOpened(new java.sql.Date(loan.getApplicationDate().getTime()));
        form.setLastPaymentDate(null);
        form.setCurrentBalance(loan.getApprovedAmount().doubleValue());
        form.setCreditLimit(0.0);
        form.setSanctionedAmount(loan.getApprovedAmount().doubleValue());
        form.setEmiAmount(emiList.get(0).emi.doubleValue());
        form.setTenureMonths(loan.getLoanTenureMonths());
        form.setPaymentHistory(null);
        form.setAccountStatus(loan.getActive() ? "Active" : "Inactive");
        return form;
    }
    private CustomerForm buildCustomerForm(LoanApplications loan) {

        CustomerForm customerForm = new CustomerForm();
        customerForm.setPan(loan.getCustomer().getPan());
        customerForm.setFullName(loan.getCustomer().getFirstName() + " " + loan.getCustomer().getLastName());
        customerForm.setBod(loan.getCustomer().getDob());
        customerForm.setGender("Male"); // Optional: fetch from loan.getCustomer().getGender() if available
        customerForm.setMobile(String.valueOf(loan.getCustomer().getPhoneNumber()));
        customerForm.setEmail(loan.getCustomer().getEmail());
        customerForm.setAadhar(loan.getCustomer().getAadhar());

        AddressForm addressForm = buildAddressForm(loan);
        customerForm.setAddress(addressForm);
        return customerForm;
    }

    private AddressForm buildAddressForm(LoanApplications loan){

        AddressForm addressForm = new AddressForm();
        addressForm.setLine(loan.getCustomer().getAddress().getCity());
        addressForm.setStreet(loan.getCustomer().getAddress().getStreet());
        addressForm.setCity(loan.getCustomer().getAddress().getCity());
        addressForm.setState(loan.getCustomer().getAddress().getState());
        addressForm.setPincode(loan.getCustomer().getAddress().getZipcode());
        return addressForm;
    }
}
