package com.company;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/iam/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class AccountController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "hello world";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = "/authenticated")
    public String authenticated() {
        return "hello";
    }

    @GetMapping(path = "/promoters")
    public String promoters() {
        return "hello world";
    }

    @GetMapping(path = "/supervisors")
    public String supervisors() {
        return "hello world";
    }
}