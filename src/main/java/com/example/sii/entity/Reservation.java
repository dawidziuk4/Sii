package com.example.sii.entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_reservation")
public class Reservation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prelection")
    private int prelection;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation() {

    }
    public Reservation(int prelection, User user) {
        this.user = user;
        this.prelection = prelection;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getPrelection() {
        return prelection;
    }

    public void setPrelection(int prelection) {
        this.prelection = prelection;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", user=" + user +", prelection=" + prelection +"]";
    }

}

