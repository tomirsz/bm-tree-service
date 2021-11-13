package com.bonsaimanager.treeservice.mapper;

import com.bonsaimanager.treeservice.model.dto.NewIrrigationDto;
import com.bonsaimanager.treeservice.model.entity.Irrigation;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import org.springframework.stereotype.Component;

@Component
public class IrrigationMapper {
    public Irrigation newIrrigationToIrrigation(Tree tree, NewIrrigationDto dto) {
        return new Irrigation()
                .setDate(dto.getDate())
                .setTree(tree)
                .setUserId(SecurityUtils.getUserId());
    }
}
