package edu.mum.cs545.springboot.service;

import edu.mum.cs545.springboot.domain.Stadium;
import java.util.Collection;

public interface IStadiumService {

    Stadium create(String stadiumName);
    Stadium retrieve(int id);
    Collection<Stadium> retrieve();
    Stadium update(int id, Stadium stadium);
    boolean delete(int id);
}

