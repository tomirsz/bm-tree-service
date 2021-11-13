package com.bonsaimanager.treeservice.repotting;

import com.bonsaimanager.treeservice.model.dto.NewRepotting;
import com.bonsaimanager.treeservice.model.dto.NewSprayingDto;
import com.bonsaimanager.treeservice.model.entity.Repot;
import com.bonsaimanager.treeservice.model.entity.Spraying;
import com.bonsaimanager.treeservice.spraying.SprayingFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/repotting")
@CrossOrigin(origins = {"http://localhost:3000", "https://bonsai-manager-tree-service.herokuapp.com"})
public class RepottingController {

    private final RepottingFacade repottingFacade;

    @GetMapping("")
    public ResponseEntity<Repot> getRepotting(@RequestParam long id) {
        return repottingFacade.getRepotting(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Repot>> getRepottings() {
        return new ResponseEntity<>(repottingFacade.getRepottings(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRepotting(@RequestBody NewRepotting dto) {
        try {
            repottingFacade.addRepotting(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSpraying(@RequestParam long id) {
        try {
            repottingFacade.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
