package com.example.sii.controller;

import com.example.sii.entity.Reservation;
import com.example.sii.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {


    @Autowired
    ReservationRepository reservRepo;

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation){
        try {
            return new ResponseEntity<>(reservRepo.save(reservation), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations()
    {
        try{
            List<Reservation> list = reservRepo.findAll();
            if(list.isEmpty())
            {
                return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Reservation>>(list,HttpStatus.OK);

        }catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id)
    {
        Optional<Reservation> user = reservRepo.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<Reservation>(user.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("reservations/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation user)
    {
        try{
            return new ResponseEntity<Reservation>(reservRepo.save(user),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
