package com.bonsaimanager.treeservice.model.dto;

import com.bonsaimanager.treeservice.model.entity.Tree;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewFertilizationDto {
    @NotBlank
    private String name;
    @NotBlank
    private LocalDate date;
    @NotNull
    private Long treeId;
}
