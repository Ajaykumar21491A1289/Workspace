package com.jocata.los.service.impl;

import com.jocata.los.data.loanapplication.dao.LoanApplicationDao;
import com.jocata.los.datamodel.loanapplication.entity.LoanApplication;
import com.jocata.los.datamodel.loanapplication.form.LoanApplicationRequest;
import com.jocata.los.datamodel.loanapplication.form.LoanApplicationResponse;
import com.jocata.los.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    @Autowired
    private LoanApplicationDao loanApplicationDao;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional
    @Override
    public LoanApplicationResponse submitApplication(LoanApplicationRequest request, MultipartFile[] files) {

        Double salary=0.0;

        for(MultipartFile file : files){
            String fileName=file.getOriginalFilename();
            String extension="";

            if(fileName!=null && fileName.contains(".")){
                extension=fileName.substring(fileName.lastIndexOf('.')+1).toLowerCase();

            }

            if ("xlsx".equals(extension)) {
                String url = "http://localhost:8084/document/getSalary";
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);
                MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
                map.add("file", file.getResource());
                HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
                ResponseEntity<Double> response = restTemplate.postForEntity(url, entity, Double.class);
                salary = response.getBody();
            }
            // If it's pdf, store it to local folder
            else if ("pdf".equals(extension)) {
                try {
                    File pdfDir = new File("C:\\Workspace\\LoanEase\\loan-application-service\\src\\main\\java\\com\\jocata\\los\\files");
                    if (!pdfDir.exists()) pdfDir.mkdirs();

                    File targetFile = new File(pdfDir, file.getOriginalFilename());
                    file.transferTo(targetFile);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to store PDF file: " + e.getMessage());
                }
            }

        }




        // Step 2: Save loan application
        LoanApplication app = new LoanApplication();
        app.setUserId(Integer.valueOf(request.getUserId()));
        app.setAmount(Double.valueOf(request.getAmount()));
        app.setPurpose(request.getPurpose());
        app.setAppliedDate(Date.valueOf(LocalDate.now()));
        app.setTermInMonths(Integer.valueOf(request.getTermInMonths()));
        app.setSalary(salary);
        app.setStatus("PENDING");
        loanApplicationDao.saveApplication(app);

        // Step 3: Return response
        LoanApplicationResponse res = new LoanApplicationResponse();
        res.setMessage("Loan Application Submitted Successfully");
        res.setSalary(salary);
        return res;
    }
}
