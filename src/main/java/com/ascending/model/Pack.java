package com.ascending.model;

import javax.persistence.*;

@Entity
@Table(name = "pack")
public class Pack {

    public Pack(){
    }
    public Pack(long id,String trackingId,String category,String destination){
        this.id = id;
        this.trackingId = trackingId;
        this.category = category;
        this.destination = destination;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "tracking_id")
    private String trackingId;
    @Column(name = "category")
    private String category;
    @Column(name = "destination")
    private String destination;
//    @Column(name = "recipient_id")
//    private long recipientId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routing_id")
    private Routing routing;

    public String getTrackingId(){
        return trackingId;
    }
    public void setTrackingid(String trackingid){
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
    public void setRecipient(Recipient recipient){
        this.recipient = recipient;
    }
    public Recipient getRecipient() {
        return recipient;
    }
//    public void setRecipientId(long recipientId){
//        this.recipientId = recipientId;
//    }
    public void setRouting(Routing routing) {
        this.routing = routing;
    }
    public Routing getRouting() {
        return routing;
    }
}
