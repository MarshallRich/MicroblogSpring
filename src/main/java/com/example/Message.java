package com.example;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by MacLap on 3/8/16.
 */

@Entity
public class Message {

    @Id
    @GeneratedValue
    int id;

    String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Message(){

    }

    public Message(String text){
        this.text = text;
    }
}
