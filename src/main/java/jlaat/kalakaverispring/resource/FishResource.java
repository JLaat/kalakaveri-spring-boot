package jlaat.kalakaverispring.resource;

import jlaat.kalakaverispring.service.FishService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fish")
public class FishResource {
    private final FishService fishService;

    public FishResource(FishService fishService) {
        this.fishService = fishService;
    }
}
