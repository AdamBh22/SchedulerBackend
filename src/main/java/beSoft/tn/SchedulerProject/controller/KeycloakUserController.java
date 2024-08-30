package beSoft.tn.SchedulerProject.controller;
import beSoft.tn.SchedulerProject.services.KeycloakUserService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keycloak/users")
public class KeycloakUserController {

    private final KeycloakUserService keycloakUserService;

    @Autowired
    public KeycloakUserController(KeycloakUserService keycloakUserService) {
        this.keycloakUserService = keycloakUserService;
    }

    @GetMapping
    public List<UserRepresentation> getAllUsers() {
        return keycloakUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserRepresentation getUserById(@PathVariable String id) {
        return keycloakUserService.getUserById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody UserRepresentation userRepresentation) {
        keycloakUserService.updateUser(id, userRepresentation);
    }
}

