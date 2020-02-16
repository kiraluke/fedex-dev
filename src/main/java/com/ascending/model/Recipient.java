package com.ascending.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recipient")
public class Recipient {
    public Recipient(){
    }
    public Recipient(long id,String name,String firstName,String lastName,String email,String adress){
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = adress;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column (name = "name")
    private String name;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "email")
    private String email;
    @Column (name = "address")
    private String address;

    @OneToMany(mappedBy = "recipient",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
//    @JoinColumn
    private Set<Pack> packs;

//    public void setId(long id) { this.id = id; }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getAddress() {
        return address;
    }

    public void setPack(Set<Pack> packs) {
        this.packs = packs;
    }
    public Set<Pack> getPack() {
        return packs;
    }
}
