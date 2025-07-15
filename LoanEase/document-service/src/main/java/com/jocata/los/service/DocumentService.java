package com.jocata.los.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocumentService {
    Double processBankStatement(MultipartFile file) throws IOException;
}
