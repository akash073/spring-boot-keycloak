package com.company;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping(path = "/user")
    public String user() {
        return "hello user";
    }

    @GetMapping(path = "/actor")
    public String supervisors() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) authentication.getPrincipal();

        AccessToken token = keycloakPrincipal.getKeycloakSecurityContext().getToken();

        System.out.println(authentication);
        System.out.println(token.getEmail());

        return "hello actor";
    }
}