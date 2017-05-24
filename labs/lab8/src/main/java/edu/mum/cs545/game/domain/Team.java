package edu.mum.cs545.game.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Player> players = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Match> matchesAsHome = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Match> matchesAsVisitor = new HashSet<>();

    public Long getId() {
        return id;
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

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Match> getMatchesAsHome() {
        return matchesAsHome;
    }

    public void setMatchesAsHome(Set<Match> matchesAsHome) {
        this.matchesAsHome = matchesAsHome;
    }

    public Set<Match> getMatchesAsVisitor() {
        return matchesAsVisitor;
    }

    public void setMatchesAsVisitor(Set<Match> matchesAsVisitor) {
        this.matchesAsVisitor = matchesAsVisitor;
    }

}
