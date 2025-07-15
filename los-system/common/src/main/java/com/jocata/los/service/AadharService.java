package com.jocata.los.service;

import com.jocata.los.response.AadharResponseForm;

public interface AadharService {

    AadharResponseForm getAadharByAadharNumber(String aadharNumber);
}
