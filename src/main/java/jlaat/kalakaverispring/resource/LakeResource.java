package jlaat.kalakaverispring.resource;

import jlaat.kalakaverispring.service.LakeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lake")
public class LakeResource {
    private final LakeService lakeService;

    public LakeResource(LakeService lakeService) {
        this.lakeService = lakeService;
    }
}
