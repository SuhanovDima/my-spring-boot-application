package suhanov.pattern.example.myspringbootapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
