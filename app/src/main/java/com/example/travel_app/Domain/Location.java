package com.example.travel_app.Domain;

public class Location {

    private int id; // 2 usages
    private String loc; // 3 usages

    public Location() {
    }

    @Override
    public String toString() {
        return loc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
