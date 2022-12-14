package com.my.zdemy.controller;

import com.my.zdemy.exception.UserNotFoundException;
import com.my.zdemy.model.User;
import com.my.zdemy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
   User getUserById(@PathVariable Long id) {
      return userRepository.findById(id)
      .orElseThrow(()->new UserNotFoundException(id));
   }

   @PutMapping("/user/{id}")
   User updateUser(@RequestBody User user, @PathVariable Long id ){
      User oldUser = userRepository.findById(id)
                 .orElseThrow(()->new UserNotFoundException(id));
      oldUser.setUserName(user.getUserName());
      oldUser.setEmail(user.getEmail());
      oldUser.setName(user.getName());
      return userRepository.save(oldUser);
   }

   @DeleteMapping("/user/{id}")
   void deleteUserById(@PathVariable Long id){
      userRepository.deleteById(id);
   }
}

/*https://github.com/Mahfuz07/education?fbclid=IwAR2XMpo2W5txY1PI57DB6n68hGZXgiC1LR51AhtcYpFZeIWqgiJP9Ba2ORE*/