package dev.project.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.api.dto.UserDTO;
import dev.project.api.entity.User;
import dev.project.api.repository.UserRepository;
import dev.project.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void insert(UserDTO user) {
        userRepository.save(new User(user.username(), user.password()));
    }

    @Override
    public void update(Long id, UserDTO User) {
        userRepository.update(id, User);
    }

    @Override
    public void delete(Long id) {
        var user = userRepository.findAllById(List.of(id)).getFirst();
        userRepository.delete(user);
    }

}
