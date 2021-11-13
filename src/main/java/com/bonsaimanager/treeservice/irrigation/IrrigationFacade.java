package com.bonsaimanager.treeservice.irrigation;

import com.bonsaimanager.treeservice.model.dto.NewIrrigationDto;
import com.bonsaimanager.treeservice.model.entity.Irrigation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class IrrigationFacade {

    private final IrrigationService irrigationService;

    public Optional<Irrigation> getIrrigation(long id) {
        log.info("Fetching irrigation with id: {}", id);
        return irrigationService.getIrrigation(id);
    }

    public List<Irrigation> getIrrigations() {
        log.info("Fetching all irrigations");
        return irrigationService.getIrrigations();
    }

    public void addIrrigation(NewIrrigationDto dto) {
        log.info("Adding irrigation: {}", dto);
        irrigationService.addIrrigation(dto);
    }

    public void delete(long id) {
        irrigationService.delete(id);
        log.info("Deleted irrigation with id: {}", id);
    }
}
