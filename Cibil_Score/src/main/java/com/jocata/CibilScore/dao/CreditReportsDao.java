package com.jocata.CibilScore.dao;

import com.jocata.CibilScore.entity.CreditReports;

public interface CreditReportsDao {

    CreditReports saveCreditReport(CreditReports creditReports);
    CreditReports findCibilScore(String pan);

}
