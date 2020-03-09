package com.example.mailapp;

import java.util.ArrayList;
import java.util.List;

public class Mails {
    private String name;
    private String description;
    private String time;
    public static List<Mails> items=new ArrayList<>();
    public static void generate(){
        items.add(new Mails("Assem Sandibayeva", "Some text","12:03"));
        items.add(new Mails("Aigerim Kaimakova", "Some text","13:30"));
        items.add(new Mails("Aktoty Saubayeva", "Some text","14:20"));
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time=time;
    }

    public Mails(String name, String description,String time){
        this.name=name;
        this.description=description;
        this.time=time;
    }

}
