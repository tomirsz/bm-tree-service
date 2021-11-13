package com.bonsaimanager.treeservice.pruning;

import com.bonsaimanager.treeservice.model.dto.NewPruningDto;
import com.bonsaimanager.treeservice.model.entity.Prune;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/pruning")
@CrossOrigin(origins = {"http://localhost:3000", "https://gp-wsb.gitlab.io"})
public class PruningController {

    private final PruningFacade pruningFacade;

    @GetMapping("")
    public ResponseEntity<Prune> getPruning(@RequestParam long id) {
        return pruningFacade.getPruning(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Prune>> getPrunings() {
        return new ResponseEntity<>(pruningFacade.getPrunings(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPruning(@RequestBody NewPruningDto dto) {
        try {
            pruningFacade.addPruning(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSpraying(@RequestParam long id) {
        try {
            pruningFacade.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
