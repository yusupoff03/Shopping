package org.example.service.user;

import lombok.RequiredArgsConstructor;
import org.example.model.user.User;
import org.example.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public User add(User user) {
        if (userRepository.checkPhoneNumber(user.getPhoneNumber())) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(UUID user_id) {
        return userRepository.getById(user_id);
    }

    @Override
    public User sign_In(String phoneNumber, String password) {
        return userRepository.sign_in(phoneNumber, password);
    }
}
