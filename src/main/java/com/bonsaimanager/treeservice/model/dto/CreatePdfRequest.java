package com.bonsaimanager.treeservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CreatePdfRequest {

    private List<PdfRequest> data = new ArrayList<>();
}
