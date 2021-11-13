package com.bonsaimanager.treeservice.pruning;

import com.bonsaimanager.treeservice.model.dto.NewPruningDto;
import com.bonsaimanager.treeservice.model.entity.Prune;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PruningFacade {

    private final PruningService pruningService;

    public Optional<Prune> getPruning(long id) {
        log.info("Fetching spraying with id: {}", id);
        return pruningService.getPrune(id);
    }

    public List<Prune> getPrunings() {
        log.info("Fetching all sprayings");
        return pruningService.getPrunings();
    }

    public void addPruning(NewPruningDto dto) {
        log.info("Adding spraying: {}", dto);
        pruningService.addPruning(dto);
    }

    public void delete(long id) {
        pruningService.delete(id);
        log.info("Deleted spraying with id: {}", id);
    }
}
