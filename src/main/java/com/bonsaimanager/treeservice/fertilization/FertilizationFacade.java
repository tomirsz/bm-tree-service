package com.bonsaimanager.treeservice.fertilization;

import com.bonsaimanager.treeservice.model.dto.NewFertilizationDto;
import com.bonsaimanager.treeservice.model.entity.Fertilization;
import com.google.common.io.Files;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class FertilizationFacade {

    private final FertilizationService fertilizationService;

    public Optional<Fertilization> getFertilization(long id) {
        log.info("Fetching fertilization with id: {}", id);
        return fertilizationService.getFertilization(id);
    }

    public List<Fertilization> getFertilizations() {
        log.info("Fetching all fertilizations");
        return fertilizationService.getFertilizations();
    }

    public void addFertilization(NewFertilizationDto dto) {
        log.info("Adding fertilization: {}", dto);
        fertilizationService.addFertilizations(dto);
    }

    public void delete(long id) {
        fertilizationService.delete(id);
        log.info("Deleted fertilization with id: {}", id);
    }
}
