package edu.mum.cs545.game.controllers;

import edu.mum.cs545.game.domain.Player;
import edu.mum.cs545.game.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayerController {

    @Autowired
    private IPlayerService service;

    @RequestMapping("player/")
    String list(Model model){
        model.addAttribute("players", service.listAll());
        return "player/list";
    }

    @RequestMapping("player/{id}")
    String show(@PathVariable Long id, Model model){
        model.addAttribute(service.getById(id));
        return "player/show";
    }

    @RequestMapping("player/new")
    public String newPlayer(Model model){
        model.addAttribute("player", new Player());
        return "player/edit";
    }

    @RequestMapping("player/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("player", service.getById(id));
        return "player/edit";
    }

    @RequestMapping(value = "player/", method = RequestMethod.POST)
    public String saveTeam(Player player){
        service.save(player);
        return "redirect:/player/" + player.getId();
    }

    @RequestMapping("player/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/player/";
    }


}
