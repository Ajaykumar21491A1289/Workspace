package com.jocata.los.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jocata.los.response.PanResponseForm;
import com.jocata.los.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PanServiceImpl implements PanService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PanResponseForm getPanServiceByPanNumber(String panNumber) {

        try {
            String URL = "http://localhost:8080/panservice/api/v1/getPanDetails?panNumber=" + panNumber;
            ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode nodeDetails = root.get("details");

            PanResponseForm panResponseForm = mapper.treeToValue(nodeDetails, PanResponseForm.class);

            return panResponseForm;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

