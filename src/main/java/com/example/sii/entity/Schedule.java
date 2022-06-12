package com.example.sii.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<String> topics =  new ArrayList<String>(3) ;;
    private List<Integer> prelections = new ArrayList<Integer>(3) ;
    private List<Time> times = new ArrayList<Time>(6) ;

    @Override
    public String toString() {
        String string = "Schedule of IT conferecne 01.06.2022."+'\n'+"Topics list: "+topics+'\n'+"Number of prelections: "+prelections.size()
                +'\n'+"Prelection #1 start at "+times.get(0)+" ends at "+times.get(1)
                +'\n'+"Prelection #2 start at "+times.get(2)+" ends at "+times.get(3)
                +'\n'+"Prelection #3 start at "+times.get(4)+" ends at "+times.get(5);
        return string;

    }

    public Schedule() {
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
