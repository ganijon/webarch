package edu.mum.cs545.game.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private int id;

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

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

//    public List<Player> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(List<Player> players) {
//        this.players = players;
//    }

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

//    public List<Match> getMatchesAsHome() {
//        return matchesAsHome;
//    }
//
//    public void setMatchesAsHome(List<Match> matchesAsHome) {
//        this.matchesAsHome = matchesAsHome;
//    }
//
//    public List<Match> getMatchesAsVisitor() {
//        return matchesAsVisitor;
//    }
//
//    public void setMatchesAsVisitor(List<Match> matchesAsVisitor) {
//        this.matchesAsVisitor = matchesAsVisitor;
//    }

}
