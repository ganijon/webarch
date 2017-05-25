package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	public Person save(Person person) {
		return personRepository.save(person);
	}
	public Person retrieve(Long id) {
		return personRepository.findOne(id);
	}
	public void delete(Person person) {
		personRepository.delete(person);
	}
	public List<Person> retrieveAll() {
		return personRepository.findAll();
	}
	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}
}
