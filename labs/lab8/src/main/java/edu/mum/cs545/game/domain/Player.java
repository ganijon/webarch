package edu.mum.cs545.game.domain;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private byte shirtNumber;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(byte shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

}
