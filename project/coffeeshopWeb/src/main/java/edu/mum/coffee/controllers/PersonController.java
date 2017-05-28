package edu.mum.coffee.controllers;

import edu.mum.coffee.model.Address;
import edu.mum.coffee.model.Authority;
import edu.mum.coffee.model.AuthorityType;
import edu.mum.coffee.model.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping("/")
    String list(Model model) {
        model.addAttribute("persons", service.retrieveAll());
        return "person/list";
    }

    @RequestMapping("/{id}")
    String show(@PathVariable Long id, Model model) {
        model.addAttribute(service.retrieve(id));
        return "person/show";
    }

    @RequestMapping("/add")
    String add(@ModelAttribute("person") Person person) {
        if(person == null) {
            person = new Person();
            person.setAddress(new Address());
        }
        return "person/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        model.addAttribute("person", service.retrieve(id));
        return "person/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Valid Person person, Authentication auth,
                  final RedirectAttributes ra) {

        Authority authority = new Authority();
        authority.setUsername(person.getEmail());
        authority.setAuthority(AuthorityType.ROLE_USER);
        person.getAuthorities().add(authority);

        Person response = service.create(person);

        if (response == null) {
            ra.addFlashAttribute("message", "Email already taken.");
            ra.addFlashAttribute("person", person);
            return "redirect:/person/add";
        }

        if (auth == null) {
            ra.addFlashAttribute("message", "Sign in with your new credentials");
            return "redirect:/login";
        } else {
            ra.addFlashAttribute("message", "Personal details updated");
            return "redirect:/person/";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    String update(@Valid Person person, Authentication authentication) {
        service.update(person);
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_USER"));
        return (hasUserRole) ? "redirect:/" : "redirect:/person/";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/person/";
    }

    @RequestMapping("/editprofile")
    String Profile(Model model, Principal principal) {
        String userEmail = principal.getName();
        model.addAttribute("person", service.findByEmail(userEmail));
        return "person/edit";
    }
}
