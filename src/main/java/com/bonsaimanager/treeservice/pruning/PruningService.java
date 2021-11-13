package com.bonsaimanager.treeservice.pruning;

import com.bonsaimanager.treeservice.mapper.PruningMapper;
import com.bonsaimanager.treeservice.model.dto.NewPruningDto;
import com.bonsaimanager.treeservice.model.dto.NewSprayingDto;
import com.bonsaimanager.treeservice.model.entity.Prune;
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
public class PruningService {

    private final PruningRepository pruningRepository;
    private final TreeFacade treeFacade;
    private final PruningMapper pruningMapper;

    Optional<Prune> getPrune(long id) {
        return pruningRepository.findByIdAndUserId(id, SecurityUtils.getUserId());
    }

    List<Prune> getPrunings() {
        return pruningRepository.findAllByUserId(SecurityUtils.getUserId());
    }

    void addPruning(NewPruningDto dto) throws NoSuchElementException {
        Optional<Tree> tree = treeFacade.getTree(dto.getTreeId());
        if (tree.isPresent()) {
            pruningRepository.save(pruningMapper.newPruningToPruning(tree.get(), dto));
        } else {
            throw new NoSuchElementException();
        }

    }

    public void delete(long id) throws NoSuchElementException {
        Optional<Prune> pruning = pruningRepository.findById(id);
        if (pruning.isPresent()) {
            pruningRepository.deleteById(pruning.get().getId(), SecurityUtils.getUserId());
        } else {
            throw new NoSuchElementException();
        }
    }
}
