package com.bonsaimanager.treeservice.model.dto;

import com.bonsaimanager.treeservice.model.entity.Tree;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewRepotting {
    @NotBlank
    private String description;
    @NotBlank
    private LocalDate date;
    @NotNull
    private Long treeId;
}
