package com.example.sii.Models;

import java.sql.Time;
import java.util.ArrayList;

public class ConferencePlan {

    private ArrayList<Prelection> prelections;

    public void setPrelections(ArrayList<Prelection> prelections) {
        this.prelections = prelections;
    }

    public ArrayList<Prelection> getPrelections() {
        return prelections;
    }
}