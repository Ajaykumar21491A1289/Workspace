package com.jocata.AdharCard.dao.impl;

import com.jocata.AdharCard.dao.AadharCardDao;
import com.jocata.AdharCard.service.AadharCardService;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;

@Repository
public class AadharCardDaoImpl implements AadharCardDao {
    @Override
    public String getAadharCardDetails() throws Exception{
        return Files.readString(Paths.get("C:\\Workspace\\AdharCard\\src\\main\\resources\\adharCardData.xml"));
    }
}
