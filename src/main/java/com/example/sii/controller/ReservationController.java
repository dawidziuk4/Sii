package com.example.sii.controller;

import com.example.sii.dto.ReservationInfo;
import com.example.sii.dto.ReservationRequest;
import com.example.sii.entity.Reservation;
import com.example.sii.entity.User;
import com.example.sii.repository.ReservationRepository;
import com.example.sii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @DeleteMapping("reservations/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable Long id)
    {
        try{
            Optional<Reservation> reserv = reservRepo.findById(id);
            if (reserv.isPresent())
            {
                reservRepo.delete(reserv.get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Autowired
    private UserRepository userRepo;


    @GetMapping("/findAllReservations")
    public List<User> findAllReservations(){
        return userRepo.findAll();
    }

    @GetMapping("/getSinglePrelectionInfo/{prelection}")
    public List<ReservationInfo> getSinglePrelectionInfo(@PathVariable int prelectionNr){
        return userRepo.getSinglePrelectionInfo(prelectionNr);
    }

    @GetMapping("/getAllPrelectionInfo")
    public List<ReservationInfo> getAllPrelectionInfo(){
        return userRepo.getAllPrelectionsInfo();
    }

    @PutMapping("/user/{login}/makeReservation")
    public String makeReservation(@RequestBody Reservation reservation, @PathVariable String login) {

        User user = userRepo.findByLogin(login);
        //CHECKING IF THERE IS SPACE ON THIS PRELECTION
        int prelection = reservation.getPrelection();
        if(reservRepo.countPrelectionAttendance(prelection) >= 5)
            return "No more free spots on this prelection";
            if(user.getReservations().isEmpty())
                user.getReservations().add(reservation);
            else{
                int size = user.getReservations().size();
                for(int i=0;i<size ;i++)
                {
                    if(reservation.getPrelection() == user.getReservations().get(i).getPrelection())
                        return "Already made reservation in this time.";
                    else
                        user.getReservations().add(reservation);
                }
            }
            userRepo.save(user);
        return user.toString();
    }

}
