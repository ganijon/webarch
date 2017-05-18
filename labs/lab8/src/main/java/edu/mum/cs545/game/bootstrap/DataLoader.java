package edu.mum.cs545.game.bootstrap;

import edu.mum.cs545.game.domain.Stadium;
import edu.mum.cs545.game.domain.Team;
import edu.mum.cs545.game.repositories.IStadiumRepository;
import edu.mum.cs545.game.repositories.ITeamRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IStadiumRepository stadiumRepository;

    @Autowired
    private ITeamRepository teamRepository;

    private Logger log = Logger.getLogger(DataLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AddStadiums();
        AddTeams();
    }

    private void AddTeams() {
        Team chelsea = new Team();
        chelsea.setName("Chelsea");
        chelsea.setCity("London");
        chelsea.setMascot("Stamford The Lion");
        chelsea.setHomeUniform("Blue kit");
        chelsea.setAwayUniform("Black kit");
        teamRepository.save(chelsea);

        log.info("Saved Chelsea - id: " + chelsea.getId());

        Team tottenham = new Team();
        tottenham.setName("Tottenham");
        tottenham.setCity("London");
        tottenham.setMascot("Chirpy");
        tottenham.setHomeUniform("White kit");
        tottenham.setAwayUniform("Gold kit");
        teamRepository.save(tottenham);

        log.info("Saved Tottenham - id: " + tottenham.getId());
    }

    private void AddStadiums() {
        Stadium sw6 = new Stadium();
        sw6.setName("Stamford Bridge");
        sw6.setCity("London");
        sw6.setState("United Kingdom");
        sw6.setImageUrl("http://www.football-pictures.net/data/media/173/StamfordBridge3.jpg");
        stadiumRepository.save(sw6);

        log.info("Saved Stamford Bridge - id: " + sw6.getId());


        Stadium whiteHartLane = new Stadium();
        whiteHartLane.setName("White Hart Lane");
        whiteHartLane.setCity("London");
        whiteHartLane.setState("United Kingdom");
        whiteHartLane.setImageUrl("https://www.footballgroundmap.com/images/photos/white-hart-lane-tottenham-hotspur.jpg");
        stadiumRepository.save(whiteHartLane);

        log.info("Saved White Hart Lane - id:" + whiteHartLane.getId());


        Stadium wembley = new Stadium();
        wembley.setName("Wembley Stadium");
        wembley.setCity("London");
        wembley.setState("United Kingdom");
        wembley.setImageUrl("http://cdn.ltstatic.com/2008/June/AK409833_393high.jpg");
        stadiumRepository.save(wembley);

        log.info("Saved Wembley Stadium - id:" + wembley.getId());
    }
}
