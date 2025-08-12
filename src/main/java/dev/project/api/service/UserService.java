package dev.project.api.service;

import java.util.Optional;

import dev.project.api.dto.UserDTO;
import dev.project.api.entity.User;

public interface UserService {

    Iterable<User> findAll();

    Optional<User> findById(Long id);

    void insert(UserDTO User);

    void update(Long id, UserDTO user);

    void delete(Long id);

}
