package edu.mum.cs545.game.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Stadium {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String city;
    private String state;
    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Match> matches = new HashSet<>();

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Set<Match> getMatches() { return matches; }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

}
