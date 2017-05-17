package edu.mum.cs545.game.services;

import edu.mum.cs545.game.domain.Stadium;
import edu.mum.cs545.game.repositories.IStadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumService implements IStadiumService {

    @Autowired
    private IStadiumRepository repository;

    @Override
    public Stadium getById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Stadium> listAll() {
        return repository.findAll();
    }

    @Override
    public Stadium save(Stadium stadium) {
        return repository.save(stadium);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
