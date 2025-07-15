package com.jocata.CibilScore.service;

import com.jocata.CibilScore.Form.CreditReportForm;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface CibilScoreService {

    CreditReportForm saveCibilScore(CreditReportForm form);
    CreditReportForm getCreditReportByPan(String pan);
}
