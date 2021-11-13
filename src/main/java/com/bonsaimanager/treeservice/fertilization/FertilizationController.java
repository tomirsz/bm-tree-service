package com.bonsaimanager.treeservice.fertilization;

import com.bonsaimanager.treeservice.model.dto.NewFertilizationDto;
import com.bonsaimanager.treeservice.model.entity.Fertilization;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/fertilization")
@CrossOrigin("*")
public class FertilizationController {

    private final FertilizationFacade fertilizationFacade;

    @GetMapping("")
    public ResponseEntity<Fertilization> getFertilization(@RequestParam long id) {
        return fertilizationFacade.getFertilization(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fertilization>> getFertilizations() {
        return new ResponseEntity<>(fertilizationFacade.getFertilizations(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addFertilization(@RequestBody NewFertilizationDto dto) {
        try {
            fertilizationFacade.addFertilization(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFertilization(@RequestParam long id) {
        try {
            fertilizationFacade.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
