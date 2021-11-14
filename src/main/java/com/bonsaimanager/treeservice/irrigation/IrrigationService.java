package com.bonsaimanager.treeservice.irrigation;

import com.bonsaimanager.treeservice.mapper.IrrigationMapper;
import com.bonsaimanager.treeservice.model.dto.NewIrrigationDto;
import com.bonsaimanager.treeservice.model.entity.Irrigation;
import com.bonsaimanager.treeservice.model.entity.Spraying;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import com.bonsaimanager.treeservice.trees.TreeFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IrrigationService {

    private final IrrigationRepository irrigationRepository;
    private final TreeFacade treeFacade;
    private final IrrigationMapper irrigationMapper;

    Optional<Irrigation> getIrrigation(long id) {
        return irrigationRepository.findByIdAndUserId(id, SecurityUtils.getUserId());
    }

    List<Irrigation> getIrrigations() {
        return irrigationRepository.findAllByUserId(SecurityUtils.getUserId());
    }

    void addIrrigation(NewIrrigationDto dto) {
        Optional<Tree> tree = treeFacade.getTree(dto.getTreeId());
        if (tree.isPresent()) {
            irrigationRepository.save(irrigationMapper.newIrrigationToIrrigation(tree.get(), dto));
        } else {
            throw new NoSuchElementException();
        }
    }

    public void delete(long id) throws NoSuchElementException {
        Optional<Irrigation> irrigation = irrigationRepository.findById(id);
        if (irrigation.isPresent()) {
            irrigationRepository.deleteByIdAndUserId(irrigation.get().getId(), SecurityUtils.getUserId());
        } else {
            throw new NoSuchElementException();
        }
    }
}
