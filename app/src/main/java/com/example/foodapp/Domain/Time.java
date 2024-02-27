package com.example.foodapp.Domain;

public class Time {
    private int Id;
    private String Value;

    @Override
    public String toString() {
        return  Value;
    }



    public Time() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

}
