package com.bonsaimanager.treeservice.trees;

import com.bonsaimanager.treeservice.mapper.TreeMapper;
import com.bonsaimanager.treeservice.model.dto.NewTreeDto;
import com.bonsaimanager.treeservice.model.dto.PdfRequest;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
class TreeService {

    private final TreeRepository treeRepository;
    private final TreeMapper treeMapper;

    Optional<Tree> getTree(long id) {
        return treeRepository.findByIdAndUserId(id, SecurityUtils.getUserId());
    }

    List<Tree> getTrees() {
        return treeRepository.findAllByUserId(SecurityUtils.getUserId());
    }

    void addTree(NewTreeDto dto) {
        treeRepository.save(treeMapper.newTreeToTree(dto));
    }

    public void delete(long id) throws NoSuchElementException {
        Optional<Tree> tree = treeRepository.findById(id);
        if (tree.isPresent()) {
            treeRepository.deleteByIdAndUserId(tree.get().getId(), SecurityUtils.getUserId());
        } else {
            throw new NoSuchElementException();
        }
    }

    public List<PdfRequest> getPdfRequest(List<Long> treesId) {
        return treeRepository.getPdfRequest(treesId, SecurityUtils.getUserId());
    }
}
