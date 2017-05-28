package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person existingPerson = personService.findByEmail(person.getEmail());
        if (existingPerson == null) {
            person = personService.save(person);
            return new ResponseEntity<Person>(person, HttpStatus.CREATED);
        } else return new ResponseEntity<Person>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> retrieveAll() {
        List<Person> persons = personService.findAll();
        if (persons.isEmpty()) {
            return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> retrieve(@PathVariable Long id) {
        Person existingPerson = personService.findById(id);

        if (existingPerson == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(existingPerson, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Person person) {
        Person existingPerson = personService.findById(person.getId());

        if (existingPerson == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            personService.save(person);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Person existingPerson = personService.findById(id);
        if (existingPerson == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            personService.delete(existingPerson);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<Person> findByEmail(@PathParam("email") String email) {
        Person person = personService.findByEmail(URLDecoder.decode(email));
        if (person == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
}
