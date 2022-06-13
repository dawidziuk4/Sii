package com.example.sii.controller;

import com.example.sii.entity.User;
import com.example.sii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @PostMapping("/users")
    public String save(@RequestBody User user){
            if(userRepo.loginIsTaken(user.getLogin())==null)
            {
                userRepo.save(user);
                return user.toString();
            }
            else{
                return "Login is already taken.";
            }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        try{
            List<User> list = userRepo.findAll();
            if(list.isEmpty())
            {
                return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<User>>(list,HttpStatus.OK);

        }catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id)
    {
       Optional<User> user = userRepo.findById(id);
       if(user.isPresent()){
           return new ResponseEntity<User>(user.get(), HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    @PatchMapping("/user/{login}")
    public ResponseEntity<User> updateUser(@RequestBody Map<Object,Object> fields,@PathVariable String login)
    {

        User user = userRepo.findByLogin(login);

            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, user, value);
            });
            return new ResponseEntity<User>(userRepo.save(user), HttpStatus.OK);
        }

    @GetMapping("/user/{login}&{email}")
    public List<Integer> getUsersReservations(@PathVariable String login,@PathVariable String email)
    {
            return userRepo.findAllReservedPrelectionByUser(login,email);
    }

    @GetMapping("users/{login}")
    public ResponseEntity<User> findUserByLogin(@RequestParam String login)
    {
        if(!userRepo.findByLogin(login).toString().isEmpty())
            return new ResponseEntity<User>(userRepo.findByLogin(login),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
