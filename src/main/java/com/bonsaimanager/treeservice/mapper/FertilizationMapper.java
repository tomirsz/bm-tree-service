package com.bonsaimanager.treeservice.mapper;

import com.bonsaimanager.treeservice.model.dto.NewFertilizationDto;
import com.bonsaimanager.treeservice.model.entity.Fertilization;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import org.springframework.stereotype.Component;

@Component
public class FertilizationMapper {
    public Fertilization newFertilizationToFertilization(Tree tree, NewFertilizationDto dto) {
        return new Fertilization()
                .setName(dto.getName())
                .setDate(dto.getDate())
                .setTree(tree)
                .setUserId(SecurityUtils.getUserId());
    }
}
