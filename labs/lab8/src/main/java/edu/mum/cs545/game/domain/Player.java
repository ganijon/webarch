package edu.mum.cs545.game.domain;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int shirtNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private Team team;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
