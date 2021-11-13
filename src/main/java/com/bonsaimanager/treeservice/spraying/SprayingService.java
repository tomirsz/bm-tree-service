package com.bonsaimanager.treeservice.spraying;

import com.bonsaimanager.treeservice.mapper.SprayingMapper;
import com.bonsaimanager.treeservice.model.dto.NewSprayingDto;
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
class SprayingService {

    private final SprayingRepository sprayingRepository;
    private final SprayingMapper sprayingMapper;
    private final TreeFacade treeFacade;

    Optional<Spraying> getSpraying(long id) {
        return sprayingRepository.findByIdAndUserId(id, SecurityUtils.getUserId());
    }

    List<Spraying> getSprayings() {
        return sprayingRepository.findAllByUserId(SecurityUtils.getUserId());
    }

    void addSpraying(NewSprayingDto dto) throws NoSuchElementException {
        Optional<Tree> tree = treeFacade.getTree(dto.getTreeId());
        if (tree.isPresent()) {
            sprayingRepository.save(sprayingMapper.newSprayingToSpraying(tree.get(), dto));
        } else {
            throw new NoSuchElementException();
        }

    }

    public void delete(long id) throws NoSuchElementException {
        Optional<Spraying> spraying = sprayingRepository.findById(id);
        if (spraying.isPresent()) {
            sprayingRepository.deleteById(spraying.get().getId(), SecurityUtils.getUserId());
        } else {
            throw new NoSuchElementException();
        }
    }
}
