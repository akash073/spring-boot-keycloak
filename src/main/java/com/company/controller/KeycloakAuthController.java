package com.company.controller;

import com.company.service.KeycloakRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/keycloak")
//@RequiredArgsConstructor
public class KeycloakAuthController {

    /*curl -X POST \
  http://localhost:8080/auth/realms/MyDemo/protocol/openid-connect/token \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: 31e37169-3f6f-5ded-2950-e5beff4ea1ab' \
  -d 'grant_type=password&client_id=my-react-client&username=john&password=john'*/

    @Autowired
    private RestTemplate restTemplate;

    @Value("${keycloak-user-info-uri}")
    private String keycloakUserInfo;

    @Autowired
    private KeycloakRestService  keycloakRestService;


    @PostMapping
    public String getToken(String username, String password) {
        return keycloakRestService.login(username,password);
    }




    @GetMapping
    public String getUserInfo(String token) {

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        return restTemplate.postForObject(keycloakUserInfo, request, String.class);
    }
}
