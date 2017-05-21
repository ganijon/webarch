package edu.mum.cs545.game.services;

import edu.mum.cs545.game.domain.Team;

public interface ITeamService {
    Team getById(Long id);
    Iterable<Team> listAll();
    Team save(Team team);
    void delete(Long id);
}
