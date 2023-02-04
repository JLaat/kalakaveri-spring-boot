package jlaat.kalakaverispring.controller;

import jlaat.kalakaverispring.model.Catch;
import jlaat.kalakaverispring.service.CatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/catch")
public class CatchController {
    public CatchService catchService;

    public CatchController(CatchService catchService) {
        this.catchService = catchService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Catch>> getAllCatches() {
        List<Catch> catches = catchService.getAllCatches();
        return new ResponseEntity<>(catches, HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Catch>> getTopCatches() {
        List<Catch> catches = catchService.getTopCatches();
        return new ResponseEntity<>(catches, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Catch> findCatch(@PathVariable("id") Long id) {
        Catch catches = catchService.findCatch(id);
        return new ResponseEntity<>(catches, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Catch> addCatch(@RequestBody Catch newCatch) {
        Catch addedCatch = catchService.addCatch(newCatch);
        return new ResponseEntity<>(addedCatch, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Catch> updateCatch(Catch newCatch) {
        Catch updatedCatch = catchService.updateCatch(newCatch);
        return new ResponseEntity<>(updatedCatch, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCatch(@PathVariable("id") Long id) {
        catchService.deleteFishById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
