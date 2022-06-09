package com.example.sii.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="tbl_user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy="user")
    private Set<Reservation> reservations;

    public User() {

    }
    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public Long getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", email=" + email +"]";
    }

}
