package edu.mum.cs545.game.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String city;
    private String mascot;
    private String homeUniform;
    private String awayUniform;

    //@OneToMany
    //private List<Player> players;

    //@OneToMany
    //private List<Match> matchesAsHome;

    //@OneToMany
    //private List<Match> matchesAsVisitor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public String getHomeUniform() {
        return homeUniform;
    }

    public void setHomeUniform(String homeUniform) {
        this.homeUniform = homeUniform;
    }

    public String getAwayUniform() {
        return awayUniform;
    }

    public void setAwayUniform(String awayUniform) {
        this.awayUniform = awayUniform;
    }


}
