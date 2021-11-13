package com.bonsaimanager.treeservice.mapper;

import com.bonsaimanager.treeservice.model.dto.NewTreeDto;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import org.springframework.stereotype.Component;

@Component
public class TreeMapper {

    public Tree newTreeToTree(NewTreeDto dto) {
        return new Tree().setName(dto.getName())
                .setLatinName(dto.getLatinName())
                .setDate(dto.getDate())
                .setUserId(SecurityUtils.getUserId());
    }
}
