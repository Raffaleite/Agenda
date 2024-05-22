package com.example.exemplofragmento;


public class Compromisso {
    private long id;
    private String date;
    private String time;
    private String description;

    public Compromisso(String date, String time, String description) {
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}





