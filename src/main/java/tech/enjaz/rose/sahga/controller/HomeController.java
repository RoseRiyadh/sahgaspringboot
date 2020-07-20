package tech.enjaz.rose.sahga.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/about")
    public @ResponseBody
    String aboutMe() {
        return "It's a me, Rosie~";
    }
}
