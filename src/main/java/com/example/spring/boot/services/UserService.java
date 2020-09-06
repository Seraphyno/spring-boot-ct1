package com.example.spring.boot.services;

import com.example.spring.boot.entities.User;
import com.example.spring.boot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User receivedUser) throws IllegalArgumentException {

        // Alternativa la unique = true in User
        Optional<User> userOp = Optional.empty();

        if (receivedUser.getUsername() != null) {
            List<User> users = userRepository.findAll();
            userOp = users.stream()
                    .filter(user -> user.getUsername() != null)
                    .filter(user -> user.getUsername().equals(receivedUser.getUsername()))
                    .findAny();
        }

        if (userOp.isPresent()) {
            throw new IllegalArgumentException("Username is taken!");
        }

        return userRepository.save(receivedUser);
    }

    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }
}
