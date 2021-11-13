package com.bonsaimanager.treeservice.repotting;

import com.bonsaimanager.treeservice.model.dto.NewRepotting;
import com.bonsaimanager.treeservice.model.entity.Repot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class RepottingFacade {

    private final RepottingService repottingService;

    public Optional<Repot> getRepotting(long id) {
        log.info("Fetching repotting with id: {}", id);
        return repottingService.getRepot(id);
    }

    public List<Repot> getRepottings() {
        log.info("Fetching all repottings");
        return repottingService.getRepots();
    }

    public void addRepotting(NewRepotting dto) {
        log.info("Adding repotting: {}", dto);
        repottingService.addRepot(dto);
    }

    public void delete(long id) {
        repottingService.delete(id);
        log.info("Deleted repotting with id: {}", id);
    }
}
