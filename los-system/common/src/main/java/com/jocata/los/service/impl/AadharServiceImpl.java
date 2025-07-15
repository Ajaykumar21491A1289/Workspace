package com.jocata.los.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jocata.los.response.AadharResponseForm;
import com.jocata.los.service.AadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AadharServiceImpl implements AadharService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AadharResponseForm getAadharByAadharNumber(String aadharNumber) {

        try {

            String URL = "http://localhost:8081/adharcard/api/v2/getAadharCardDetails?aadharId=" + aadharNumber;
            ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode nodeDetails = root.get("details");
            AadharResponseForm aadharResponseForm =mapper.treeToValue(nodeDetails,AadharResponseForm.class);
            return aadharResponseForm;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}