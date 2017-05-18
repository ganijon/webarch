package edu.mum.cs545.game.repositories;

import edu.mum.cs545.game.domain.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITeamRepository extends CrudRepository<Team, Integer> {
    List<Team> findAllByNameAndCity(String name, String city);
}
