package edu.mum.cs545.game.repositories;

import edu.mum.cs545.game.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends CrudRepository<Player, Long> {
}
