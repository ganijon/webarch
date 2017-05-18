package edu.mum.cs545.game.services;

import edu.mum.cs545.game.domain.Team;
import edu.mum.cs545.game.repositories.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private ITeamRepository repository;

    @Override
    public Team getById(int id) { return repository.findOne(id); }

    @Override
    public Iterable<Team> listAll() {
        return repository.findAll();
    }

    @Override
    public Team save(Team team) {
        return repository.save(team);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
