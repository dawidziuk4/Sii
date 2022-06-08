package com.example.sii.Controllers;

import com.example.sii.Models.Prelection;
import com.example.sii.Models.Subject;

import java.sql.Time;
import java.util.ArrayList;

public class ConferenceController {

    private void createConferencePlan()
    {
        for(int i = 0 ; i < 3;i++)
        {
            Prelection prelection = new Prelection();
            prelection.setNum_of_participants(0);

            //Setting time for prelections: 10:00, 12:00 and 14:00
            Time time = new Time(10+i*2,00,00);
            prelection.setStartTime(time);

            //Creating subjects list for each prelection
            ArrayList<Subject> subjects = new ArrayList<Subject>();
                for(int j = 0 ; j < 3;j++)
                {
                    Subject subject = new Subject();
                    subject.setTopic("Topic number: "+j);
                    subject.setNum_of_participants(0);
                    subjects.add(subject);
                }
            prelection.setSubjects(subjects);
        }
    }
}
