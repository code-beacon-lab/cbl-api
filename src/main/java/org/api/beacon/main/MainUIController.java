package org.api.beacon.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainUIController {
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/test")
    public String testPage() {
        return "pages/test/index";
    }
}
