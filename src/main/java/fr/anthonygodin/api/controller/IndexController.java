package fr.anthonygodin.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AnthoGdn on 14/03/17.
 */
@RestController
public class IndexController {

    public static final String INDEX_STRING = "You are on AnthoGdn API.";

    @GetMapping("/")
    public String index() {
        return INDEX_STRING;
    }
}
