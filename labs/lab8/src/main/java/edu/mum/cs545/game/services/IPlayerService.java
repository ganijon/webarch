package edu.mum.cs545.game.services;

import edu.mum.cs545.game.domain.Player;

public interface IPlayerService {
    Player getById(int id);
    Iterable<Player> listAll();
    Player save(Player player);
    void delete(int id);
}
