package com.bonsaimanager.treeservice.spraying;

import com.bonsaimanager.treeservice.model.dto.NewSprayingDto;
import com.bonsaimanager.treeservice.model.entity.Spraying;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class SprayingFacade {

    private final SprayingService sprayingService;

    public Optional<Spraying> getSpraying(long id) {
        log.info("Fetching spraying with id: {}", id);
        return sprayingService.getSpraying(id);
    }

    public List<Spraying> getSprayings() {
        log.info("Fetching all sprayings");
        return sprayingService.getSprayings();
    }

    public void addSpraying(NewSprayingDto dto) {
        log.info("Adding spraying: {}", dto);
        sprayingService.addSpraying(dto);
    }

    public void delete(long id) {
        sprayingService.delete(id);
        log.info("Deleted spraying with id: {}", id);
    }
}
