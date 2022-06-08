package com.example.sii.Controllers;

import com.example.sii.Models.Prelection;
import com.example.sii.Models.Reservation;
import com.example.sii.Models.Subject;
import com.example.sii.Models.User;

public class ReservationController {


    public Reservation makeReservation(User user, Subject subject, Prelection prelection)
    {
        Reservation newReservation = new Reservation();

        boolean possible = checkAvailabilityOfPrelection(prelection);

        if(possible)
        {
            newReservation.setUser(user);
            newReservation.setSubject(subject);
            newReservation.setPrelection(prelection);
        }
        else{

            noMoreFreeSpots();

        }

        return newReservation;
    }

    private void noMoreFreeSpots() {
        System.out.println("There is no free spots in this time. Please consider making a reservation on another prelection.");
    }

    private boolean checkAvailabilityOfPrelection(Prelection prelection) {

        return prelection.getNum_of_participants() < 5;

    }

}
