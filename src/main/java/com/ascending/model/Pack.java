package com.ascending.model;

public class Pack {
    private int trackingid;
    private String type;
    private String destination;

    public int getTrackingid(){
        return trackingid;
    }
    public void setTrackingid(int trackingid){
        this.trackingid = trackingid;
    }
    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDestination(){
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
