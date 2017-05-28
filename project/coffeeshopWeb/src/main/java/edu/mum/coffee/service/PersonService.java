package edu.mum.coffee.service;

import edu.mum.coffee.model.Person;

import java.util.List;

public interface PersonService {
    Person create(Person person);
    Person retrieve(Long id);
    void update(Person person);
	void delete(Long id);
    List<Person> retrieveAll();
    Person findByEmail(String email);
}
