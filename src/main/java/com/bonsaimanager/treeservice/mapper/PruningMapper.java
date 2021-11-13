package com.bonsaimanager.treeservice.mapper;

import com.bonsaimanager.treeservice.model.dto.NewPruningDto;
import com.bonsaimanager.treeservice.model.entity.Prune;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import org.springframework.stereotype.Component;

@Component
public class PruningMapper {
    public Prune newPruningToPruning(Tree tree, NewPruningDto dto) {
        return new Prune()
                .setDescription(dto.getDescription())
                .setDate(dto.getDate())
                .setTree(tree)
                .setUserId(SecurityUtils.getUserId());
    }
}
