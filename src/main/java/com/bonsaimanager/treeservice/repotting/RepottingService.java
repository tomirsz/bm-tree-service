package com.bonsaimanager.treeservice.repotting;

import com.bonsaimanager.treeservice.mapper.RepottingMapper;
import com.bonsaimanager.treeservice.model.dto.NewRepotting;
import com.bonsaimanager.treeservice.model.entity.Repot;
import com.bonsaimanager.treeservice.model.entity.Spraying;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import com.bonsaimanager.treeservice.trees.TreeFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RepottingService {

    private final RepottingRepository repottingRepository;
    private final TreeFacade treeFacade;
    private final RepottingMapper repottingMapper;

    Optional<Repot> getRepot(long id) {
        return repottingRepository.findByIdAndUserId(id, SecurityUtils.getUserId());
    }

    List<Repot> getRepots() {
        return repottingRepository.findAllByUserId(SecurityUtils.getUserId());
    }

    void addRepot(NewRepotting dto) {
        Optional<Tree> tree = treeFacade.getTree(dto.getTreeId());
        if (tree.isPresent()) {
            repottingRepository.save(repottingMapper.newRepottingToRepotting(tree.get(), dto));
        } else {
            throw new NoSuchElementException();
        }
    }

    public void delete(long id) throws NoSuchElementException {
        Optional<Repot> repot = repottingRepository.findById(id);
        if (repot.isPresent()) {
            repottingRepository.deleteById(repot.get().getId(), SecurityUtils.getUserId());
        } else {
            throw new NoSuchElementException();
        }
    }

}
