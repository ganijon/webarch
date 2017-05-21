package edu.mum.cs545.game.services;

import edu.mum.cs545.game.domain.Match;
import edu.mum.cs545.game.repositories.IMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService implements IMatchService {

    @Autowired
    private IMatchRepository repository;

    @Override
    public Match getById(Long id) { return repository.findOne(id); }

    @Override
    public Iterable<Match> listAll() {
        return repository.findAll();
    }

    @Override
    public Match save(Match match) {
        return repository.save(match);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
