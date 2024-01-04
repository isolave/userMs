package com.company.user.service;

import com.company.user.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getUsers();
    Optional<UserEntity> getUserById(Long id);
    UserEntity addUser(UserEntity user);
    String deleteUser(Long id);
    UserEntity updateUser(Long id, UserEntity user);

}
