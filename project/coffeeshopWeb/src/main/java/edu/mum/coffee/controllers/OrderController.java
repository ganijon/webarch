package edu.mum.coffee.controllers;

import edu.mum.coffee.model.Order;
import edu.mum.coffee.model.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    String listAll(Model model, Authentication authentication) {

        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_USER"));

        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

        if (hasAdminRole) {
            model.addAttribute("orders", orderService.findAll());
        }

        if (hasUserRole) {
            model.addAttribute("orders",
                    orderService.findByPersonEmail(authentication.getName()));
        }

        return "order/list";
    }

    @RequestMapping("/{id}")
    String show(@PathVariable Long id, Model model) {
        model.addAttribute(orderService.findById(id));
        return "order/show";
    }


    @RequestMapping("/checkout")
    String checkout(HttpSession session, Principal principal, RedirectAttributes redirectAtt) {

        Person person = personService.findByEmail(principal.getName());

        Order recentOrder = (Order) session.getAttribute("cart");
        recentOrder.setOrderDate(new Date());
        recentOrder.setPerson(person);

        Order result = orderService.create(recentOrder);

        if (result != null) {

            session.removeAttribute("cart");

            redirectAtt.addFlashAttribute("message",
                    String.format("Your recent order #%s has been placed.", result.getId()));
        } else {
            redirectAtt.addFlashAttribute("message",
                    String.format("Something went wrong with you order #%s.", result.getId()));
        }

        return "redirect:/order/";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.findById(id));
        return "order/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Valid Order order) {
        orderService.create(order);
        return "redirect:/order/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    String update(@Valid Order order) {
        orderService.update(order);
        return "redirect:/order/";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable Long id) {
        orderService.delete(id);
        return "redirect:/order/";
    }
}
