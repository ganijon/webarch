package edu.mum.cs545.game.domain;


import javax.persistence.*;
import java.util.Date;

//@Entity
public class Match {

    //@Id
    //@GeneratedValue
    private long id;

    private Date date;
    private Date startTime;
    private int homeScore;
    private int visitorScore;
    private Team visitorTeam;
    private Team homeTeam;
    private Stadium stadium;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getVisitorScore() {
        return visitorScore;
    }

    public void setVisitorScore(int visitorScore) {
        this.visitorScore = visitorScore;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
