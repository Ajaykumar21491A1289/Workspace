package com.jocata.los.service;

import com.jocata.los.request.CreditReportForm;
import org.springframework.web.bind.annotation.RequestParam;

public interface AddAccountDetailsToCibilApiService {
    CreditReportForm addAccountDetailsToCibilApi(String loanId);
}
