package com.company.user;

import com.company.user.model.UserEntity;
import com.company.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/company")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public List<UserEntity> getUsers (){
        return userService.getUsers();
    }

    @GetMapping("/getUserById")
    public Optional<UserEntity> getUserById(@RequestParam("id") Long id){
    return userService.getUserById(id);
    }

    @PostMapping("/addUser")
    public UserEntity addUser(@RequestBody UserEntity user){
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/updateUser")
    public UserEntity updateUser(@RequestParam("id") Long id, @RequestBody UserEntity user){
        return userService.updateUser(id, user);
    }
}
