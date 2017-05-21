package edu.mum.cs545.game.bootstrap;

import edu.mum.cs545.game.domain.*;
import edu.mum.cs545.game.repositories.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");


    @Autowired
    private IStadiumRepository stadiumRepository;


    private Logger log = Logger.getLogger(DataLoader.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        // PLAYERS
        Player hazard = new Player();
        hazard.setName("Eden Hazard");
        hazard.setShirtNumber(10);

        Player willian = new Player();
        willian.setName("Willian Borges Da Silva");
        willian.setShirtNumber(22);

        Player harryKane = new Player();
        harryKane.setName("Harry Kane");
        harryKane.setShirtNumber(10);

        Player deleAlli = new Player();
        deleAlli.setName("Dele Alli");
        deleAlli.setShirtNumber(20);



        // TEAMS
        Team tottenham = new Team();
        tottenham.setName("Tottenham");
        tottenham.setCity("London");
        tottenham.setMascot("Chirpy");
        tottenham.setHomeUniform("White kit");
        tottenham.setAwayUniform("Gold kit");

        Team chelsea = new Team();
        chelsea.setName("Chelsea");
        chelsea.setCity("London");
        chelsea.setMascot("Stamford The Lion");
        chelsea.setHomeUniform("Blue kit");
        chelsea.setAwayUniform("Black kit");


        // PLAYER-TEAM ASSOCIATIONS
        hazard.setTeam(chelsea);
        willian.setTeam(chelsea);

        chelsea.getPlayers().add(hazard);
        chelsea.getPlayers().add(willian);

        harryKane.setTeam(tottenham);
        deleAlli.setTeam(tottenham);

        tottenham.getPlayers().add(harryKane);
        tottenham.getPlayers().add(deleAlli);


        // MATCHES
        TournamentMatch faCupMatch = new TournamentMatch();
        faCupMatch.setTournament("FA Cup, Semi-Finals");
        faCupMatch.setHomeScore(4);
        faCupMatch.setVisitorScore(2);
        try {
            faCupMatch.setDateTime(dateformat.parse("22-04-2017 12:15:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        FriendlyMatch friendlymatch = new FriendlyMatch();
        friendlymatch.setAward(AwardType.TROPHY);
        friendlymatch.setHomeScore(4);
        friendlymatch.setVisitorScore(2);
        try {
            friendlymatch.setDateTime(dateformat.parse("22-04-2017 12:15:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // MATCH-TEAM ASSOCIATIONS
        friendlymatch.setHomeTeam(chelsea);
        friendlymatch.setVisitorTeam(tottenham);

        chelsea.getMatchesAsHome().add(friendlymatch);
        tottenham.getMatchesAsVisitor().add(friendlymatch);

        faCupMatch.setHomeTeam(chelsea);
        faCupMatch.setVisitorTeam(tottenham);

        chelsea.getMatchesAsHome().add(faCupMatch);
        tottenham.getMatchesAsVisitor().add(faCupMatch);


        // STADIUMS
        Stadium sw6 = new Stadium();
        sw6.setName("Stamford Bridge");
        sw6.setCity("London");
        sw6.setState("United Kingdom");
        sw6.setImageUrl("http://www.football-pictures.net/data/media/173/StamfordBridge3.jpg");

        Stadium whiteHartLane = new Stadium();
        whiteHartLane.setName("White Hart Lane");
        whiteHartLane.setCity("London");
        whiteHartLane.setState("United Kingdom");
        whiteHartLane.setImageUrl("https://www.footballgroundmap.com/images/photos/white-hart-lane-tottenham-hotspur.jpg");

        Stadium wembley = new Stadium();
        wembley.setName("Wembley Stadium");
        wembley.setCity("London");
        wembley.setState("United Kingdom");
        wembley.setImageUrl("http://cdn.ltstatic.com/2008/June/AK409833_393high.jpg");


        // MATCH-STADIUM ASSOCIATIONS
        friendlymatch.setStadium(sw6);
        sw6.getMatches().add(friendlymatch);

        faCupMatch.setStadium(wembley);
        wembley.getMatches().add(faCupMatch);


        // PERSIST SESSION
        stadiumRepository.save(sw6);
        stadiumRepository.save(whiteHartLane);
        stadiumRepository.save(wembley);
    }

}
