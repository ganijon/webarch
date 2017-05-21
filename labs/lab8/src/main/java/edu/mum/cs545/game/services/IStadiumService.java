package edu.mum.cs545.game.services;

import edu.mum.cs545.game.domain.Stadium;

public interface IStadiumService {
    Stadium getById(Long id);
    Iterable<Stadium> listAll();
    Stadium save(Stadium stadium);
    void delete(Long id);
}

