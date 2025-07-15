package com.jocata.los;

import com.jocata.los.response.PanResponseForm;
import com.jocata.los.service.AadharService;
import com.jocata.los.service.CibilScoreService;
import com.jocata.los.service.PanService;
import com.jocata.los.service.impl.AadharServiceImpl;
import com.jocata.los.service.impl.CibilScoreServiceImpl;
import com.jocata.los.service.impl.PanServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PanService panService = new PanServiceImpl();
       System.out.println( panService.getPanServiceByPanNumber("BNZPA1234F"));


        AadharService aadharService = new AadharServiceImpl();
        System.out.println(aadharService.getAadharByAadharNumber("123456789012"));

        CibilScoreService cibilScoreService = new CibilScoreServiceImpl();
        System.out.println(cibilScoreService.getCibilScoreByPan("BNZPA1234F"));

    }
}