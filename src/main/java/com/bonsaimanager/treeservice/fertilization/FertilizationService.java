package com.bonsaimanager.treeservice.fertilization;

import com.bonsaimanager.treeservice.mapper.FertilizationMapper;
import com.bonsaimanager.treeservice.model.dto.NewFertilizationDto;
import com.bonsaimanager.treeservice.model.entity.Fertilization;
import com.bonsaimanager.treeservice.model.entity.Spraying;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.trees.TreeFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FertilizationService {

    private final FertilizationRepository fertilizationRepository;
    private final TreeFacade treeFacade;
    private final FertilizationMapper fertilizationMapper;

    Optional<Fertilization> getFertilization(long id) {
        return fertilizationRepository.findById(id);
    }

    List<Fertilization> getFertilizations() {
        return fertilizationRepository.findAll();
    }

    void addFertilizations(NewFertilizationDto dto) {
        Optional<Tree> tree = treeFacade.getTree(dto.getTreeId());
        if (tree.isPresent()) {
            fertilizationRepository.save(fertilizationMapper.newFertilizationToFertilization(tree.get(), dto));
        } else {
            throw new NoSuchElementException();
        }
    }

    public void delete(long id) throws NoSuchElementException {
        Optional<Fertilization> fertilization = fertilizationRepository.findById(id);
        if (fertilization.isPresent()) {
            fertilizationRepository.delete(fertilization.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}
