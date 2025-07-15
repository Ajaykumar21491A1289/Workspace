package com.jocata.AdharCard.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.jocata.AdharCard.dao.AadharCardDao;
import com.jocata.AdharCard.entity.PayLoad;
import com.jocata.AdharCard.form.AadharCardResForm;
import com.jocata.AdharCard.service.AadharCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AadharCardServiceImpl implements AadharCardService {

    @Autowired
    AadharCardDao dao;


    @Override
    public PayLoad getAadharCardDetails(String aadharId) throws Exception{
        String data = dao.getAadharCardDetails();
        XmlMapper xmlMapper = new XmlMapper();
        List<PayLoad> list = xmlMapper.readValue(data, new TypeReference<List<PayLoad>>() {});

        for(PayLoad card:list){
            if(card.getNumber().equals(aadharId)) return card;
        }
        return null;
    }
}
