package com.bonsaimanager.treeservice.trees;

import com.bonsaimanager.treeservice.model.dto.NewTreeDto;
import com.bonsaimanager.treeservice.model.entity.Tree;
import com.bonsaimanager.treeservice.security.SecurityConfig;
import com.bonsaimanager.treeservice.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/tree")
@CrossOrigin(origins = {"http://localhost:3000", "https://gp-wsb.gitlab.io"})
class TreeController {

    private final TreeFacade treeFacade;

    @GetMapping("")
    public ResponseEntity<Tree> getTree(@RequestParam long id) {
        return treeFacade.getTree(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tree>> getTrees() {
        System.out.println(SecurityUtils.getUserId());
        return new ResponseEntity<>(treeFacade.getTrees(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTree(@RequestBody NewTreeDto dto) {
        treeFacade.addTree(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTree(@RequestParam long id) {
        try {
            treeFacade.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
