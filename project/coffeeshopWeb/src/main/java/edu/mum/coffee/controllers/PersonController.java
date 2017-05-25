package edu.mum.coffee.controllers;

import edu.mum.coffee.domain.Address;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping("/")
    String list(Model model){
        model.addAttribute("persons", service.retrieveAll());
        return "person/list";
    }

    @RequestMapping("/{id}")
    String show(@PathVariable Long id, Model model){
        model.addAttribute(service.retrieve(id));
        return "person/show";
    }

    @RequestMapping("/add")
    String add(Model model){
        Person newPerson = new Person();
        newPerson.setAddress(new Address());
        model.addAttribute("person", newPerson);
        return "person/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model){
        model.addAttribute("person", service.retrieve(id));
        return "person/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Valid Person person){
        service.create(person);
        return "redirect:/person/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    String update(@Valid Person person){
        service.update(person);
        return "redirect:/person/";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/person/";
    }
}
