package edu.mum.cs545.game.repositories;

import edu.mum.cs545.game.domain.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchRepository extends CrudRepository<Match,Long> {
}

