package edu.mum.cs545.game.controllers;

import edu.mum.cs545.game.domain.Team;
import edu.mum.cs545.game.services.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
public class TeamController {

    @Autowired
    private ITeamService service;

    @RequestMapping("team/")
    String list(Model model){
        model.addAttribute("teams", service.listAll());
        return "team/list";
    }

    @RequestMapping("team/{id}")
    String show(@PathVariable Integer id, Model model){
        model.addAttribute(service.getById(id));
        return "team/show";
    }

    @RequestMapping("team/new")
    public String newTeam(Model model){
        model.addAttribute("team", new Team());
        return "team/edit";
    }

    @RequestMapping("team/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("team", service.getById(id));
        return "team/edit";
    }

    @RequestMapping(value = "team/", method = RequestMethod.POST)
    public String saveTeam(Team team){
        service.save(team);
        return "redirect:/team/" + team.getId();
    }

    @RequestMapping("team/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/team/";
    }


}
