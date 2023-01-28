package jlaat.kalakaverispring.controller;

import jlaat.kalakaverispring.model.Lake;
import jlaat.kalakaverispring.service.LakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import org.xml.sax.EntityResolver;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lake")
public class LakeController {
    private final LakeService lakeService;

    public LakeController(LakeService lakeService) {
        this.lakeService = lakeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lake>> getAll() {
        List<Lake> lakes = lakeService.getAllLakes();
        return new ResponseEntity<>(lakes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Lake> findLake(@PathVariable("id") Long id) {
        Lake lakes = lakeService.findLake(id);
        return new ResponseEntity<>(lakes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Lake> addLake(@RequestBody Lake lake) {
        Lake addedLake = lakeService.addLake(lake);
        return new ResponseEntity<>(addedLake, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Lake> updateLake(Lake lake) {
        Lake updatedLake = lakeService.updateLake(lake);
        return new ResponseEntity<>(updatedLake, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLake(@PathVariable("id") Long id) {
        lakeService.deleteLake(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
