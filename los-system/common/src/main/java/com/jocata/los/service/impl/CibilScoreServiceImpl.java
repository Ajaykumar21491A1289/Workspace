package com.jocata.los.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jocata.los.response.AccountForm;
import com.jocata.los.response.CibilScoreForm;
import com.jocata.los.response.CibilScoreResponseForm;
import com.jocata.los.response.EnquiryForm;
import com.jocata.los.service.CibilScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CibilScoreServiceImpl implements CibilScoreService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CibilScoreResponseForm getCibilScoreByPan(String panNumber) {

        try {

            String URL = "http://localhost:8082/cibilscore/api/v3/getCibilScoreDetails?panNumber=" + panNumber;
            ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());

            CibilScoreResponseForm responseForm=new CibilScoreResponseForm();

            JsonNode cibilNode = root.get("cibilScore");
            JsonNode accountsNode = root.get("accountsList");
            JsonNode enquiryNode = root.get("enquiriesList");


            CibilScoreForm cibilScoreForm = mapper.treeToValue(cibilNode,CibilScoreForm.class);
            List<AccountForm> accounts = mapper.readerForListOf(AccountForm.class).readValue(accountsNode);
            List<EnquiryForm> enquiry=mapper.readerForListOf(EnquiryForm.class).readValue(enquiryNode);


            responseForm.setCibilScoreForm(cibilScoreForm);
            responseForm.setEnquiryForms(enquiry);
            responseForm.setAccountFormList(accounts);

            return responseForm;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
