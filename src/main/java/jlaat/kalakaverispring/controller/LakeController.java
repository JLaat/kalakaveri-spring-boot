package jlaat.kalakaverispring.controller;

import jlaat.kalakaverispring.service.LakeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lake")
public class LakeController {
    private final LakeService lakeService;

    public LakeController(LakeService lakeService) {
        this.lakeService = lakeService;
    }
}
