package com.jocata.PanService.dao.impl;

import com.jocata.PanService.dao.PanServiceDao;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class PanServiceDaoImpl implements PanServiceDao {
    @Override
    public String getPanDetails(String panNumber) throws Exception{
            return Files.readString(Paths.get("C:\\Workspace\\Pan_Service\\src\\main\\resources\\PanResponse.json"));
    }
}
