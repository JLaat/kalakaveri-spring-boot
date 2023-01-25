package jlaat.kalakaverispring.controller;

import jlaat.kalakaverispring.model.Lure;
import java.util.List;
import jlaat.kalakaverispring.service.LureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lure")
public class LureController {
    private final LureService lureService;

public LureController(LureService lureService) {
        this.lureService = lureService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Lure>> getAllLures() {
    List<Lure> lures = lureService.getAllLures();
    return new ResponseEntity<>(lures, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Lure> findLure(@PathVariable("id") Long id) {
    Lure lure = lureService.findLure(id);
    return new ResponseEntity<>(lure, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Lure> addLure(Lure lure) {
    Lure addedLure = lureService.addLure(lure);
    return new ResponseEntity<>(addedLure, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Lure> updateLure(Lure lure) {
    Lure updatedLure = lureService.updateLure(lure);
    return new ResponseEntity<>(updatedLure, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLure(@PathVariable("id") Long id) {
    lureService.deleteLure(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}
