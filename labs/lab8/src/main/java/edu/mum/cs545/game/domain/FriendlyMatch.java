package edu.mum.cs545.game.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("F")
public class FriendlyMatch extends Match {

    @Enumerated(EnumType.STRING)
    private AwardType award;


    public AwardType getAward() {
        return award;
    }

    public void setAward(AwardType award) {
        this.award = award;
    }
}
