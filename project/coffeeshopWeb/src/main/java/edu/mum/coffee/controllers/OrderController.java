package edu.mum.coffee.controllers;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Date;
import javax.validation.Valid;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    String list(Model model){
        model.addAttribute("orders", orderService.retrieveAll());
        return "order/list";
    }

    @RequestMapping("/{id}")
    String show(@PathVariable Long id, Model model){
        model.addAttribute(orderService.retrieve(id));
        return "order/show";
    }

    @RequestMapping("/add")
    String add(Model model, Principal principal){
        //TODO: Implement user selection from principal
        Order newOrder = new Order();
        newOrder.setOrderDate(new Date());
        newOrder.setPerson(personService.retrieve(2L));
        model.addAttribute("order", newOrder);
        return "order/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model){
        model.addAttribute("order", orderService.retrieve(id));
        return "order/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Valid Order order){
        orderService.create(order);
        return "redirect:/order/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    String update(@Valid Order order){
        orderService.update(order);
        return "redirect:/order/";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable Long id){
        orderService.delete(id);
        return "redirect:/order/";
    }
}
