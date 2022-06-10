package com.example.sii.dto;

import com.example.sii.entity.Reservation;
import com.example.sii.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationInfo {

    private String login;
    private int prelection;
}
