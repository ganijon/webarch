package edu.mum.cs545.game.controllers;

import edu.mum.cs545.game.domain.Match;
import edu.mum.cs545.game.services.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MatchController {

    @Autowired
    private IMatchService service;

    @RequestMapping("match/")
    String list(Model model){
        model.addAttribute("matches", service.listAll());
        return "match/list";
    }

    @RequestMapping("match/{id}")
    String show(@PathVariable Long id, Model model){
        model.addAttribute(service.getById(id));
        return "match/show";
    }

    @RequestMapping("match/new")
    public String newMatch(Model model){
        //TODO: create view model for Friendly & Tournament match
        //model.addAttribute("match", new Match());
        return "match/edit";
    }

    @RequestMapping("match/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("match", service.getById(id));
        return "match/edit";
    }

    @RequestMapping(value = "match/", method = RequestMethod.POST)
    public String saveMatch(Match match){
        service.save(match);
        return "redirect:/match/" + match.getId();
    }

    @RequestMapping("match/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/match/";
    }


}
