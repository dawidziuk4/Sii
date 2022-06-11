package com.example.sii.controller;

import com.example.sii.entity.Plan;
import com.example.sii.entity.Reservation;
import com.example.sii.entity.User;
import com.example.sii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
public class MainController {

    @GetMapping("/plan")
    public String getPlan()
    {
        Plan plan = new Plan();
        try{
            return plan.toString();

        }catch (Exception e)
        {
            return plan.toString();
        }
    }
}
