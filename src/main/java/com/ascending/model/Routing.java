package com.ascending.model;

public class Routing {
    private int id;
    private String category;
    private String pirority;
    private String area;
    private int trackingid;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory(){
        return category;
    }

    public void setPirority(String pirority) {
        this.pirority = pirority;
    }
    public String getPirority(){
        return pirority;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public String getArea(){
        return area;
    }

    public void setTrackingid(int trackingid) {
        this.trackingid = trackingid;
    }

    public int getTrackingid() {
        return trackingid;
    }
}
