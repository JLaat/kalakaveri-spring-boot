package jlaat.kalakaverispring.controller;

import jlaat.kalakaverispring.service.LureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lure")
public class LureController {
    private final LureService lureService;

public LureController(LureService lureService) {
        this.lureService = lureService;
    }
}
