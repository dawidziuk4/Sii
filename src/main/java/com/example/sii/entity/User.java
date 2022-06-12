package com.example.sii.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="tbl_user")
public class User{

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String email;
    @OneToMany(targetEntity = Reservation.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ur_fk",referencedColumnName = "id")
    private List<Reservation> reservations;

    public void sendEmail() throws IOException
    {
        Date date = new Date();
        String str = "Pomyślnie zarezerwowano miejsce na prelekcje.\nDo: "+email+"\nData: "+date;
        BufferedWriter writer = new BufferedWriter(new FileWriter(login));
        writer.write(str);

        writer.close();

    }

}
