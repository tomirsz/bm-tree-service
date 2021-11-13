package com.bonsaimanager.treeservice.mapper;

import com.bonsaimanager.treeservice.model.dto.NewRepotting;
import com.bonsaimanager.treeservice.model.entity.Repot;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import org.springframework.stereotype.Component;

@Component
public class RepottingMapper {
    public Repot newRepottingToRepotting(Tree tree, NewRepotting dto) {
        return new Repot()
                .setDescription(dto.getDescription())
                .setDate(dto.getDate())
                .setTree(tree)
                .setUserId(SecurityUtils.getUserId());
    }
}
