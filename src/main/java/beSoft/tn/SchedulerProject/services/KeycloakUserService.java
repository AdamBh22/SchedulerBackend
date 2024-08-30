package beSoft.tn.SchedulerProject.services;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeycloakUserService {

    private final UsersResource usersResource;

    @Autowired
    public KeycloakUserService(UsersResource usersResource) {
        this.usersResource = usersResource;
    }

    public List<UserRepresentation> getAllUsers() {
        return usersResource.list();
    }

    public UserRepresentation getUserById(String userId) {
        return usersResource.get(userId).toRepresentation();
    }

    public void updateUser(String userId, UserRepresentation userRepresentation) {
        usersResource.get(userId).update(userRepresentation);
    }
}
