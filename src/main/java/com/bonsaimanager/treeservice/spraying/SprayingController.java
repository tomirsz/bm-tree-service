package com.bonsaimanager.treeservice.spraying;

import com.bonsaimanager.treeservice.model.dto.NewSprayingDto;
import com.bonsaimanager.treeservice.model.entity.Spraying;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/spraying")
@CrossOrigin(origins = {"http://localhost:3000", "https://bonsai-manager-tree-service.herokuapp.com"})
class SprayingController {

    private final SprayingFacade sprayingFacade;

    @GetMapping("")
    public ResponseEntity<Spraying> getSpraying(@RequestParam long id) {
        return sprayingFacade.getSpraying(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Spraying>> getSprayings() {
        return new ResponseEntity<>(sprayingFacade.getSprayings(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSpraying(@RequestBody NewSprayingDto dto) {
        try {
            sprayingFacade.addSpraying(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSpraying(@RequestParam long id) {
        try {
            sprayingFacade.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
