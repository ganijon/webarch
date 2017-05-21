package edu.mum.cs545.game.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class TournamentMatch extends Match {

    private String tournament;
    private int homePoints;
    private int visitorPoints;

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public int getHomePoints() {
        return homePoints;
    }

    public void setHomePoints(int homePoints) {
        this.homePoints = homePoints;
    }

    public int getVisitorPoints() {
        return visitorPoints;
    }

    public void setVisitorPoints(int visitorPoints) {
        this.visitorPoints = visitorPoints;
    }

}
