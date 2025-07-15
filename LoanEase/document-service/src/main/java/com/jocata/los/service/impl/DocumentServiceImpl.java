package com.jocata.los.service.impl;

import com.jocata.los.service.DocumentService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Override
    public Double processBankStatement(MultipartFile file) throws IOException {
        try(InputStream is =file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)){
            Sheet sheet = workbook.getSheetAt(0);
            for(Row row: sheet){
                if(row.getRowNum() ==0) continue;

                String description = row.getCell(1).getStringCellValue();
                String type = row.getCell(2).getStringCellValue();

                if(description.toLowerCase().contains("salary") && type.equalsIgnoreCase("credit")){
                    return row.getCell(3).getNumericCellValue();
                }

            }
        }
        return null;
    }
}
