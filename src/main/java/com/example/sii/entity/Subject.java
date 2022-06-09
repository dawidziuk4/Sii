package com.example.sii.entity;

public class Subject {
    private Long id;
    private String topic;
    private int num_of_participants;

    public String getTopic() {
        return topic;
    }

    public int getNum_of_participants() {
        return num_of_participants;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setNum_of_participants(int num_of_participants) {
        this.num_of_participants = num_of_participants;
    }
}
