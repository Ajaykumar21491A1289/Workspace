package com.jocata.los.service.impl;

import com.jocata.los.dao.AddressDao;
import com.jocata.los.dao.CustomersDao;
import com.jocata.los.dao.IncomeDetailsDao;
import com.jocata.los.dao.LoanDetailsDao;
import com.jocata.los.entity.Address;
import com.jocata.los.entity.Customers;
import com.jocata.los.entity.IncomeDetails;
import com.jocata.los.entity.LoanApplications;
import com.jocata.los.form.*;
import com.jocata.los.service.LoanApplicationService;
import com.jocata.los.util.LoanStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    @Autowired
    CustomersDao customersDao;

    @Autowired
    AddressDao addressDao;

    @Autowired
    LoanDetailsDao loanDetailsDao;

    @Autowired
    IncomeDetailsDao incomeDetailsDao;


    @Override
    @Transactional
    public LoanDetailsForm addLaonApplication(LoanDetailsForm form) {

        Customers customer =setCustomerDetails(form.getCustomerForm());
        setAddressDetails(form.getCustomerForm().getAddressForm(),customer);
        setLoanDetails(form.getLoanApplicationForm(),customer);
        setIncomeDetails(form.getIncomeDetailsForm(),customer);

        return form;
    }

    @Override
    public LoanDetailsForm getLaonApplication(String loanId) {
        LoanApplications entity = loanDetailsDao.getLoan(Integer.parseInt(loanId));

        LoanDetailsForm form = new LoanDetailsForm();
        form.setCustomerForm(buildCustomerForm(entity.getCustomer()));
        form.setIncomeDetailsForm(buildIncomeDetailsForm(entity.getCustomer().getIncomeDetails()));
        form.setLoanApplicationForm(buildLoanApplicationForm(entity));

        return form;
    }




    private Customers setCustomerDetails(CustomerForm form) {
        Customers customer = new Customers();
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setEmail(form.getEmail());
        customer.setPhoneNumber(Long.parseLong(form.getPhoneNumber()));
        customer.setDob(Date.valueOf(form.getDob()));
        customer.setAadhar(form.getAadhar());
        customer.setPan(form.getPan());

        return customersDao.addCustomer(customer);
    }

    private void setAddressDetails(AddressForm addressForm,Customers customer) {

        Address address = new Address();
        address.setStreet(addressForm.getStreet());
        address.setCity(addressForm.getCity());
        address.setState(addressForm.getState());
        address.setZipcode(addressForm.getZipCode());
        address.setCountry(addressForm.getCountry());
        address.setCustomer(customer);
        addressDao.addAddress(address);
    }

    private void setLoanDetails(LoanApplicationForm form,Customers customer) {

        LoanApplications loan = new LoanApplications();
        loan.setCustomer(customer);
        loan.setLoanAmount(new BigDecimal(form.getLoanAmount()));
        loan.setLoanType(form.getLoanType());
        loan.setLoanTenureMonths(Integer.parseInt(form.getTenureMonths()));
        loan.setLoanPurpose(form.getPurpose());
        loan.setStatus(LoanStatus.valueOf(form.getStatus()));
        loan.setApprovedAmount(new BigDecimal(form.getApprovedAmount()));
        loan.setActive(Boolean.parseBoolean(form.getIsActive()));

        loanDetailsDao.addLoan(loan);
    }


    private void setIncomeDetails(IncomeDetailsForm form,Customers customer) {

        IncomeDetails incomeDetails = new IncomeDetails();
        incomeDetails.setCustomer(customer);
        incomeDetails.setMonthlyIncome(new BigDecimal(form.getMonthlyIncome()));
        incomeDetails.setEmploymentStatus(form.getEmploymentStatus());
        incomeDetails.setEmployerName(form.getEmployerName());
        incomeDetails.setYearsAtJob(Integer.valueOf(form.getYearAtJob()));

        incomeDetailsDao.addIncomeDetails(incomeDetails);
    }

    private CustomerForm buildCustomerForm(Customers customers){
        CustomerForm form = new CustomerForm();
        form.setCustomerId(String.valueOf(customers.getCustomerId()));
        form.setFirstName(customers.getFirstName());
        form.setLastName(customers.getLastName());
        form.setEmail(customers.getEmail());
        form.setPhoneNumber(String.valueOf(customers.getPhoneNumber()));
        form.setDob(String.valueOf(customers.getDob()));
        form.setCreatedAt(customers.getCreatedAt().toString());
        Timestamp createdAt = customers.getCreatedAt();
        /*if (createdAt != null) {
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createdAt);
            form.setCreatedAt(formattedDate);
        }*/
        form.setAadhar(customers.getAadhar());
        form.setPan(customers.getPan());
        form.setAddressForm(buildAddressForm(customers.getAddress()));
        return form;
    }

    private AddressForm buildAddressForm(Address address){
        AddressForm form = new AddressForm();
        form.setCustomerId(String.valueOf(address.getCustomer().getCustomerId()));
        form.setStreet(address.getStreet());
        form.setCity(address.getCity());
        form.setState(address.getState());
        form.setZipCode(address.getZipcode());
        form.setCountry(address.getCountry());
        return form;
    }

    private IncomeDetailsForm buildIncomeDetailsForm(IncomeDetails incomeDetails){

        IncomeDetailsForm form = new IncomeDetailsForm();
        form.setCustomerId(String.valueOf(incomeDetails.getCustomer().getCustomerId()));
        form.setMonthlyIncome(String.valueOf(incomeDetails.getMonthlyIncome()));
        form.setEmploymentStatus(incomeDetails.getEmploymentStatus());
        form.setEmployerName(incomeDetails.getEmployerName());
        form.setYearAtJob(String.valueOf(incomeDetails.getYearsAtJob()));
        return form;
    }

    private LoanApplicationForm buildLoanApplicationForm(LoanApplications loanApplications){

        LoanApplicationForm form = new LoanApplicationForm();
        form.setCustomerId(String.valueOf(loanApplications.getCustomer().getCustomerId()));
        form.setLoanAmount(String.valueOf(loanApplications.getLoanAmount()));
        form.setLoanType(loanApplications.getLoanType());
        form.setTenureMonths(String.valueOf(loanApplications.getLoanTenureMonths()));
        form.setPurpose(loanApplications.getLoanPurpose());
        form.setApplicationDate(String.valueOf(loanApplications.getApplicationDate()));
        form.setStatus(String.valueOf(loanApplications.getStatus()));
        form.setApprovedAmount(String.valueOf(loanApplications.getApprovedAmount()));
        form.setIsActive(String.valueOf(loanApplications.getActive()));
        return form;
    }






}
