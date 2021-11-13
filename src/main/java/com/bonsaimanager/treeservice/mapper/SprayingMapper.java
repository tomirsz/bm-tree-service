package com.bonsaimanager.treeservice.mapper;

import com.bonsaimanager.treeservice.model.dto.NewSprayingDto;
import com.bonsaimanager.treeservice.model.entity.Spraying;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import org.springframework.stereotype.Component;

@Component
public class SprayingMapper {

    public Spraying newSprayingToSpraying(Tree tree, NewSprayingDto dto) {
        return new Spraying()
                .setDescription(dto.getDescription())
                .setDate(dto.getDate())
                .setTree(tree)
                .setUserId(SecurityUtils.getUserId());
    }
}
