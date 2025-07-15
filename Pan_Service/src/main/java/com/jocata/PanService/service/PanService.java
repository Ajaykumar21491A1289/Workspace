package com.jocata.PanService.service;

import com.jocata.PanService.entity.PanDetails;

public interface PanService {

    PanDetails getPanDetails(String panNumber) throws Exception;

}
