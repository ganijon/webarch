package edu.mum.cs545.game.services;

import edu.mum.cs545.game.domain.Match;

public interface IMatchService {
    Match getById(Long id);
    Iterable<Match> listAll();
    Match save(Match match);
    void delete(Long id);
}
