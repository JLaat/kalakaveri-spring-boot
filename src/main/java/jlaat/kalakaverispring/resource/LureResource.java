package jlaat.kalakaverispring.resource;

import jlaat.kalakaverispring.service.LureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lure")
public class LureResource {
    private final LureService lureService;

public LureResource(LureService lureService) {
        this.lureService = lureService;
    }
}
