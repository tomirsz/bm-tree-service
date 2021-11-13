package com.bonsaimanager.treeservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class NewSprayingDto {
    @NotBlank
    private String description;
    @NotBlank
    private LocalDate date;
    @NotBlank
    private long treeId;
}
