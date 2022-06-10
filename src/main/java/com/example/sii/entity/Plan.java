package com.example.sii.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Plan {
    private List<String> topics =  new ArrayList<String>(3) ;;
    private List<Integer> prelections = new ArrayList<Integer>(3) ;
    private List<Time> times = new ArrayList<Time>(6) ;

    @Override
    public String toString() {
        return "Plan{" +
                "topics=" + topics +
                ", prelections=" + prelections +
                ", times=" + times +
                '}';
    }

    public Plan() {
        topics.add("Topic number 1");
        topics.add("Topic number 2");
        topics.add("Topic number 3");

        prelections.add(1);
        prelections.add(2);
        prelections.add(3);

        times.add(new Time(10,00,00));
        times.add(new Time(11,45,00));
        times.add(new Time(12,00,00));
        times.add(new Time(13,45,00));
        times.add(new Time(14,00,00));
        times.add(new Time(15,45,00));

    }
}
