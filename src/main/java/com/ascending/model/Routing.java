package com.ascending.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routing")
public class Routing {

    public Routing(){
    }
//    public Routing(int id,String pirority,String area,int trackingid){
//        this.id = id;
//        this.pirority = pirority;
//        this.area = area;
//        this.trackingid = trackingid;
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column (name = "pirority")
    private String pirority;
    @Column (name = "area")
    private String area;
    @OneToMany(mappedBy = "pack")
    @JoinColumn
    private Set<Pack> pack;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() { return id; }

    public void setPirority(String pirority) {
        this.pirority = pirority;
    }

    public String getPirority(){ return pirority; }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea(){
        return area;
    }


    public void setPack(Set<Pack> pack) {
        this.pack = pack;
    }
    public Set<Pack> getPack() {
        return pack;
    }
}
