package com.bonsaimanager.treeservice.trees;

import com.bonsaimanager.treeservice.model.dto.NewTreeDto;
import com.bonsaimanager.treeservice.model.dto.PdfRequest;
import com.bonsaimanager.treeservice.model.entity.Tree;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TreeFacade {

    private final TreeService treeService;

    public Optional<Tree> getTree(long id) {
        log.info("Fetching tree with id: {}", id);
        return treeService.getTree(id);
    }

    public List<Tree> getTrees() {
        log.info("Fetching all trees");
        return treeService.getTrees();
    }

    public void addTree(NewTreeDto dto) {
        treeService.addTree(dto);
        log.info("Adding tree: {}", dto);
    }

    public void delete(long id) {
        treeService.delete(id);
        log.info("Deleted tree with id: {}", id);
    }

    public List<PdfRequest> getPdfRequest(List<Long> treesId) {
        log.info("Fetching trees for pdf with id: {}", treesId);
        return treeService.getPdfRequest(treesId);
    }
}
