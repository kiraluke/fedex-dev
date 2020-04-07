package com.ascending.model;

import javax.persistence.*;

@Entity
@Table(name = "pack")
public class Pack {

    public Pack(){
    }
    public Pack(Long id,String trackingId,String category,String destination){
        this.id = id;
        this.trackingId = trackingId;
        this.category = category;
        this.destination = destination;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tracking_id")
    private String trackingId;
    @Column(name = "category")
    private String category;
    @Column(name = "destination")
    private String destination;

//    @Column(name = "user_id")
//    private long userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routing_id")
    private Routing routing;

    public Long getId() {
        return id;
    }
    public String getTrackingId(){
        return trackingId;
    }
    public void setTrackingId(String trackingId){
        this.trackingId = trackingId;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDestination(){
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser() {
        return user;
    }
//    public void setUserId(long userId){
//        this.userId = userId;
//    }
    public void setRouting(Routing routing) {
        this.routing = routing;
    }
    public Routing getRouting() {
        return routing;
    }
}
