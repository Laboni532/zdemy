package com.my.zdemy.controller;

import com.my.zdemy.model.User;
import com.my.zdemy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
   @Autowired
   private UserRepository userRepository;

   @PostMapping("/user")
    User newUser(@RequestBody User newUser){
       return userRepository.save(newUser);
   }
   @GetMapping("/user")
   List<User> getAllUsers(){
      return userRepository.findAll();
   }

   @GetMapping("/user/{id}")
   Optional<User> getUserById(@PathVariable Long id) {
      return userRepository.findById(id);
   }

}
