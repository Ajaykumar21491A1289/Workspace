package com.jocata.los.service;

import com.jocata.los.datamodel.loanapplication.form.LoanApplicationRequest;
import com.jocata.los.datamodel.loanapplication.form.LoanApplicationResponse;
import org.springframework.web.multipart.MultipartFile;

public interface LoanApplicationService {

    LoanApplicationResponse submitApplication(LoanApplicationRequest request, MultipartFile[] files);
}
