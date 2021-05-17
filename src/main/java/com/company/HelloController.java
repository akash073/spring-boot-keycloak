package com.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     *const keycloakCfg = {
     *   url: "http://localhost:8080/auth",
     *   realm: "MyDemo",
     *   clientId: "my-react-client",
     *   onLoad: 'login-required'
     * };
     */
    @GetMapping(path = {"/", "index"})
    public String hello() {
        return "index";
    }
}
