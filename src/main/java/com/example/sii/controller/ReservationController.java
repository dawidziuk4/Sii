package com.example.sii.controller;

import com.example.sii.dto.ReservationInfo;
import com.example.sii.entity.Reservation;
import com.example.sii.entity.User;
import com.example.sii.repository.ReservationRepository;
import com.example.sii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservRepo;

    @Autowired
    private UserRepository userRepo;

    @PutMapping("/reservations/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation user)
    {
        try{
            return new ResponseEntity<Reservation>(reservRepo.save(user),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPrelectionInfo/{prelection}")
    public List<ReservationInfo> getSinglePrelectionInfo(@PathVariable int prelection){
        return userRepo.getSinglePrelectionInfo(prelection);
    }

    @GetMapping("/getAllReservationsInfo")
    public List<ReservationInfo> getAllReservationsInfo(){
        return userRepo.getAllRservationsInfo();
    }

    @PutMapping("/users/makeReservation")
    public String makeReservation(@RequestBody ReservationInfo reservationInfo) {

        //READING INFORMATION FROM REQUESTBODY
        Reservation reservation = new Reservation();
        reservation.setPrelection(reservationInfo.getPrelection());
        reservation.setTopic(reservationInfo.getTopic());
        String login = reservationInfo.getLogin();

        User user = userRepo.findByLogin(login);
        //CHECKING IF THERE IS SPACE ON THIS PRELECTION

            int prelection = reservation.getPrelection();
            if (reservRepo.countPrelectionAttendance(prelection) >= 5)
                return "No more free spots on this prelection.";

            //IF USER HAS NO RESERVATIONS
            if (user.getReservations().isEmpty()) {
                user.getReservations().add(reservation);
                try {
                    user.sendEmail();
                } catch (IOException e) {
                    System.err.println("Error while saving to a file.");
                }

            }
            else { //IF USER HAS NO RESERVATIONS
                int size = user.getReservations().size();
                for (int i = 0; i < size; i++) { //CHECK IF USER CAN RESERVE A SPOT
                    if (reservation.getPrelection() == user.getReservations().get(i).getPrelection())
                        return "Already made reservation in this time.";
                    else
                    {
                        user.getReservations().add(reservation);
                        try {
                            user.sendEmail();
                        }catch (IOException e){
                            System.err.println("Error while saving to a file.");
                        }

                    }

                }
            }
            userRepo.save(user);
            return user.toString();

    }
    @DeleteMapping("user/{login}/deleteReservation/{prelection}")
    public ResponseEntity<String> deleteReservation(@PathVariable String login,@PathVariable int prelection) {

            Long id = reservRepo.findIdByPrelectionAndLogin(prelection, login);
            if (id==null)
                return new ResponseEntity<>("There is no reservation for this prelection",HttpStatus.OK);
            Optional<Reservation> reserv = reservRepo.findById(id);
            if(reserv.isPresent()){
                reservRepo.delete(reserv.get());
                return new ResponseEntity<>("Reservation has been canceled",HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>("There is no reservation for this prelection",HttpStatus.NO_CONTENT);
            }

    }
    @GetMapping("/prelection/{nr}")
    public String numOfAttendeesOfSinglePrelection(@PathVariable int nr)
    {
        float maxNumberOfAttendees = 4f;
        float number =reservRepo.countPrelectionAttendance(nr)/maxNumberOfAttendees*100;
        String string = number+"%";
        return string;
    }

    @GetMapping("/prelections")
    public String numOfAttendeesOfAllPrelections()
    {
        String string ="";
        for(int i=1;i<4;i++)
        {
             float maxNumberOfAttendees = 4f;
             float number = reservRepo.countPrelectionAttendance(i)/maxNumberOfAttendees*100;
             string += "Prelection #"+i+" has "+number + "% of maximum spots.\n";

        }
        return string;
    }

    @GetMapping("/topic/{nr}")
    public String numOfAttendeesOfSingleTopic(@PathVariable int nr)
    {
        float number =(float)reservRepo.countChosenTopic(nr)/reservRepo.count()*100;
        String string = number+"%";
        return string;
    }

    @GetMapping("/topics")
    public String numOfAttendeesOfAllTopics()
    {
        String string ="";
        for(int i=1;i<4;i++)
        {
            float number = (float)reservRepo.countChosenTopic(i)/ reservRepo.count()*100;
            string += "Topic #"+i+" has "+number + "%\n";

        }
        return string;
    }

}
