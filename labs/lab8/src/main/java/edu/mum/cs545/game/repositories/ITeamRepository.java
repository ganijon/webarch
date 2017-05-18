package edu.mum.cs545.game.repositories;

import edu.mum.cs545.game.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface ITeamRepository extends CrudRepository<Team, Integer> {
}
