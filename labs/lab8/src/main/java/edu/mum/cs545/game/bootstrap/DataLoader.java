package edu.mum.cs545.game.bootstrap;

import edu.mum.cs545.game.domain.Stadium;
import edu.mum.cs545.game.repositories.IStadiumRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IStadiumRepository stadiumRepository;

    private Logger log = Logger.getLogger(DataLoader.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Stadium sw6 = new Stadium();
        sw6.setName("Stamford Bridge");
        sw6.setCity("London");
        sw6.setState("United Kingdom");
        sw6.setImageUrl("http://www.football-pictures.net/data/media/173/StamfordBridge3.jpg");
        stadiumRepository.save(sw6);

        log.info("Saved Stamford Bridge - id: " + sw6.getId());

        Stadium wembley = new Stadium();
        wembley.setName("Wembley Stadium");
        wembley.setCity("London");
        wembley.setState("United Kingdom");
        wembley.setImageUrl("http://cdn.ltstatic.com/2008/June/AK409833_393high.jpg");
        stadiumRepository.save(wembley);

        log.info("Saved Wembley Stadium - id:" + wembley.getId());
    }
}
