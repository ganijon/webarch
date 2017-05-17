package edu.mum.cs545.game.repositories;

import edu.mum.cs545.game.domain.Stadium;
import org.springframework.data.repository.CrudRepository;

public interface IStadiumRepository extends CrudRepository<Stadium, Integer> {
}
