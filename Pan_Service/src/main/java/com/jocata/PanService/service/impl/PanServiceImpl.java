package com.jocata.PanService.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jocata.PanService.dao.PanServiceDao;
import com.jocata.PanService.entity.PanDetails;
import com.jocata.PanService.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanServiceImpl implements PanService {

    @Autowired
    PanServiceDao dao;

    @Override
    public PanDetails getPanDetails(String panNumber) throws Exception{
        String data = dao.getPanDetails(panNumber);
        ObjectMapper objectMapper = new ObjectMapper();
        List<PanDetails> list = objectMapper.readValue(data, new TypeReference<List<PanDetails>>() {});

        for (PanDetails entity : list) {
            if (entity.getPanNumber().equalsIgnoreCase(panNumber)) {
                return entity;

            }
        }
        return null;
    }


}
