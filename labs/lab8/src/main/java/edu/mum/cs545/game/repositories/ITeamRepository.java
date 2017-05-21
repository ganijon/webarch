package edu.mum.cs545.game.repositories;

import edu.mum.cs545.game.domain.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ITeamRepository extends CrudRepository<Team,Long> {

}
