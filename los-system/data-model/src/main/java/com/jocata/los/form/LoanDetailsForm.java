package com.jocata.los.form;

public class LoanDetailsForm {

    private CustomerForm customerForm;
    private LoanApplicationForm loanApplicationForm;
    private IncomeDetailsForm incomeDetailsForm;

    public CustomerForm getCustomerForm() {
        return customerForm;
    }

    public void setCustomerForm(CustomerForm customerForm) {
        this.customerForm = customerForm;
    }

    public LoanApplicationForm getLoanApplicationForm() {
        return loanApplicationForm;
    }

    public void setLoanApplicationForm(LoanApplicationForm loanApplicationForm) {
        this.loanApplicationForm = loanApplicationForm;
    }

    public IncomeDetailsForm getIncomeDetailsForm() {
        return incomeDetailsForm;
    }

    public void setIncomeDetailsForm(IncomeDetailsForm incomeDetailsForm) {
        this.incomeDetailsForm = incomeDetailsForm;
    }
}
