package com.example.sii.Models;

import java.sql.Time;
import java.util.ArrayList;

public class Prelection {
    private Time startTime;
    private int num_of_participants;
    private ArrayList<Subject> subjects;

    public Time getStartTime() {
        return startTime;
    }

    public int getNum_of_participants() {
        return num_of_participants;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setNum_of_participants(int num_of_participants) {
        this.num_of_participants = num_of_participants;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
}
