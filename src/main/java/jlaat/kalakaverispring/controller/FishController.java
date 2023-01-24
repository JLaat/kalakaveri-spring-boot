package jlaat.kalakaverispring.controller;

import jlaat.kalakaverispring.service.FishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jlaat.kalakaverispring.model.Fish;
import java.util.List;

@RestController
@RequestMapping("/fish")
public class FishController {
    private final FishService fishService;

    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fish>> getAllFishes() {
        List<Fish> fishes = fishService.findAllFishes();
        return new ResponseEntity<>(fishes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    ResponseEntity<Fish> getFishById(@PathVariable("id") Long id) {
        Fish fishes =  fishService.findFish(id);
        return new ResponseEntity<Fish>(fishes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Fish> addFish(@RequestBody Fish fish) {
        Fish newFish = fishService.addFish(fish);
        return new ResponseEntity<>(newFish, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fish> updateFish(Fish fish) {
        Fish updatedFish = fishService.updateFish(fish);
        return new ResponseEntity<Fish>(updatedFish, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFish(@PathVariable("id") Long id) {
        fishService.deleteFish(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
