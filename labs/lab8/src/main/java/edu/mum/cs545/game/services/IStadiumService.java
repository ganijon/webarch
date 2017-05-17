package edu.mum.cs545.game.services;

import edu.mum.cs545.game.domain.Stadium;

public interface IStadiumService {
    Stadium getById(int id);
    Iterable<Stadium> listAll();
    Stadium save(Stadium stadium);
    void delete(int id);
}

