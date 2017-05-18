package edu.mum.cs545.game.controllers;

import edu.mum.cs545.game.domain.Stadium;
import edu.mum.cs545.game.services.IStadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class StadiumController {

    @Autowired
    IStadiumService service;

    @RequestMapping("stadium/")
    String list(Model model){
        model.addAttribute("stadiums", service.listAll());
        return "stadium/list";
    }

    @RequestMapping("stadium/{id}")
    String show(@PathVariable Integer id, Model model){
        model.addAttribute(service.getById(id));
        return "stadium/show";
    }

    @RequestMapping("stadium/new")
    public String newStadium(Model model){
        model.addAttribute("stadium", new Stadium());
        return "stadium/edit";
    }

    @RequestMapping("stadium/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("stadium", service.getById(id));
        return "stadium/edit";
    }

    @RequestMapping(value = "stadium/", method = RequestMethod.POST)
    public String saveStadium(Stadium stadium){
        service.save(stadium);
        return "redirect:/stadium/" + stadium.getId();
    }

    @RequestMapping("stadium/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/stadium/";
    }
}
