package com.bonsaimanager.treeservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class NewTreeDto {

    @NotBlank
    private String name;
    @NotBlank
    private String latinName;
    @NotNull
    private LocalDate date;
}
