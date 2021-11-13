package com.bonsaimanager.treeservice.connector;

import com.bonsaimanager.treeservice.model.dto.CreatePdfRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "pdf-service")
public interface PdfServiceConnector {

    @PostMapping("/pdf/create")
    @ResponseBody
    ResponseEntity<byte[]> createPdf(@RequestBody CreatePdfRequest dto);
}
