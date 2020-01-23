package com.ascending.model;

public class Recipient {
    private int id;
    private String name;
    private String first_name;
    private String last_name;
    private String email;
    private String adress;
    private int trackingid;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setTrackingid(int trackingid) {
        this.trackingid = trackingid;
    }

    public int getTrackingid() {
        return trackingid;
    }
}
