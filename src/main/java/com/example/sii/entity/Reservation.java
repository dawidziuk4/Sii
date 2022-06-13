package com.example.sii.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="tbl_reservation")
public class Reservation{

    @Id
    @GeneratedValue
    private Long id;
    private int prelection;
    private int topic;

}

