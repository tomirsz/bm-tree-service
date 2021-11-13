package com.bonsaimanager.treeservice.pdf;

import com.bonsaimanager.treeservice.model.dto.CreatePdfRequest;
import com.bonsaimanager.treeservice.model.dto.TreeIdsDto;
import com.bonsaimanager.treeservice.provider.PdfServiceProvider;
import com.bonsaimanager.treeservice.trees.TreeFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/pdf")
public class PdfController {

    private final PdfServiceProvider pdfServiceProvider;
    private final TreeFacade treeFacade;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<byte[]> createPdf(@RequestBody TreeIdsDto treesId) {
        CreatePdfRequest createPdfRequest = new CreatePdfRequest();
        createPdfRequest.setData(treeFacade.getPdfRequest(treesId.getTreeIds()));
        ResponseEntity<byte[]> pdf = pdfServiceProvider.createPdf(createPdfRequest);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=trees.pdf");
        header.setContentLength(Objects.requireNonNull(pdf.getBody()).length);

        return new ResponseEntity<>(pdf.getBody(), header, HttpStatus.OK);
    }
}
