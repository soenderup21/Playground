package com.example.playground;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.util.Date;

public class Route implements Serializable {

    public String routeSetterName;
    public String grading;
    public String Location;
    public String color;
    public boolean isBoulder;
    public Date date;

    public Route(){

    }
    public Route(String routeSetterName, String Grading, String Location, String color, boolean isBoulder){
        this.date = new Date();
        this.routeSetterName = routeSetterName;
        this.grading = Grading;
        this.Location = Location;
        this.color = color;
        this.isBoulder = isBoulder;
    }


}