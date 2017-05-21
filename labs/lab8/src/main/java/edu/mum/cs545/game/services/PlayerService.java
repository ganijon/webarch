package edu.mum.cs545.game.services;

import edu.mum.cs545.game.domain.Player;
import edu.mum.cs545.game.repositories.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private IPlayerRepository repository;

    @Override
    public Player getById(Long id) { return repository.findOne(id); }

    @Override
    public Iterable<Player> listAll() {
        return repository.findAll();
    }

    @Override
    public Player save(Player player) {
        return repository.save(player);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
