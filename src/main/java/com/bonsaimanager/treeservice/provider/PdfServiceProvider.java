package com.bonsaimanager.treeservice.provider;

import com.bonsaimanager.treeservice.connector.PdfServiceConnector;
import com.bonsaimanager.treeservice.model.dto.CreatePdfRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PdfServiceProvider {

    private final PdfServiceConnector pdfServiceConnector;

    public  ResponseEntity<byte[]> createPdf(CreatePdfRequest dto) {
       return pdfServiceConnector.createPdf(dto);
    }
}
