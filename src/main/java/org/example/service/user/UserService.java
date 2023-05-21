package org.example.service.user;

import org.example.model.user.User;

import java.util.UUID;

public interface UserService {
    User add(User user);
    User getById(UUID user_id);
    User sign_In(String phoneNumber,String password);
}
