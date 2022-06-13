package com.example.sii.controller;

import com.example.sii.entity.Schedule;
import org.springframework.web.bind.annotation.*;


@RestController
public class PlanController {

    @GetMapping("/plan")
    public String getPlan()
    {
        Schedule schedule = new Schedule();
        try{
            return schedule.toString();

        }catch (Exception e)
        {
            return schedule.toString();
        }
    }
}
