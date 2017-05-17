package edu.mum.cs545.game.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stadium {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String city;
    private String state;

    //@OneToMany
    //private List<Match> matches;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    public List<Match> getMatches() {
//        return matches;
//    }
//
//    public void setMatches(List<Match> matches) {
//        this.matches = matches;
//    }
}
