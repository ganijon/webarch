package edu.mum.cs545.game.controllers;

import edu.mum.cs545.game.domain.Stadium;
import edu.mum.cs545.game.services.IStadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
@RequestMapping("/stadium")
public class StadiumController {

    @Autowired
    IStadiumService service;

    @RequestMapping("/")
    String list(Model model){
        model.addAttribute("stadiums", service.listAll());
        return "/stadium/list";
    }

    @RequestMapping("/{id}")
    String show(@PathVariable Integer id, Model model){
        model.addAttribute(service.getById(id));
        return "stadium/show";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String save(Stadium stadium){
        service.save(stadium);
        return "redirect:/stadium/" + stadium.getId();
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", service.getById(id));
        return "stadium/edit";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/stadium/list";
    }
}
