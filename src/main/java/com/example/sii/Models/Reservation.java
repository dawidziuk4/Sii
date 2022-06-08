package com.example.sii.Models;

public class Reservation {
    private User user;
    private Subject subject;
    private Prelection prelection;

    private int Id;

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setPrelection(Prelection prelection) {
        this.prelection = prelection;
    }



    public Subject getSubject() {
        return subject;
    }

    public Prelection getPrelection() {
        return prelection;
    }
}
