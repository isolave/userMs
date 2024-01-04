package com.company.user.service.impl;

import com.company.user.dao.UserDao;
import com.company.user.model.UserEntity;
import com.company.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userDao.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return userDao.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        if(userDao.findById(id).isPresent()) {
            userDao.deleteById(id);
            return "Usuario Eliminado";
        }else {
            return "No se encontro id Usuario";
        }
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity newUser = userDao.findById(id).orElseThrow(()->new RuntimeException("No existe ID de usuario a Actualizar"));
        newUser.setUserName(user.getUserName());
        newUser.setUserAddress(user.getUserAddress());
        return userDao.save(newUser);
    }


}
