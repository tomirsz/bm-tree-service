package com.bonsaimanager.treeservice.irrigation;

import com.bonsaimanager.treeservice.model.dto.NewIrrigationDto;
import com.bonsaimanager.treeservice.model.entity.Irrigation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/irrigation")
@CrossOrigin(origins = {"http://localhost:3000", "https://gp-wsb.gitlab.io"})
public class IrrigationController {

    private final IrrigationFacade irrigationFacade;

    @GetMapping("")
    public ResponseEntity<Irrigation> getIrrigation(@RequestParam long id) {
        return irrigationFacade.getIrrigation(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Irrigation>> getIrrigations() {
        return new ResponseEntity<>(irrigationFacade.getIrrigations(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addIrrigation(@RequestBody NewIrrigationDto dto) {
        try {
            irrigationFacade.addIrrigation(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteIrrigation(@RequestParam long id) {
        try {
            irrigationFacade.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
