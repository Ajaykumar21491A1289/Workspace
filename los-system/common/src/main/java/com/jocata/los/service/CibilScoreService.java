package com.jocata.los.service;

import com.jocata.los.response.CibilScoreResponseForm;

public interface CibilScoreService {

    CibilScoreResponseForm getCibilScoreByPan(String panNumber);
}
