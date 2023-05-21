package org.example.repository.user;

import org.example.model.user.User;

import java.util.UUID;

public interface UserRepository {
    User getById(UUID id);
    User save(User user);
    Boolean checkPhoneNumber(String phoneNumber);
    User sign_in(String username,String password);


}
