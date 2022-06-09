package com.example.sii.controller;

import com.example.sii.entity.User;
import com.example.sii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MainController {

//        @Autowired
//        UserRepository userRepository;
//        @GetMapping("/users")
//        public ResponseEntity<List<User>> getAllTutorials(@RequestParam(required = false) String login) {
//            try {
//                User user = new User();
//                if (login != null)
//                {
//                    user =userRepository.findByLogin(login);
//                    return new ResponseEntity(user, HttpStatus.OK);
//                }
//
//            } catch (Exception e) {
//                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//            return null;
//        }
}
