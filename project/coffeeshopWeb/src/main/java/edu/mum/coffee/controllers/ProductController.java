package edu.mum.coffee.controllers;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    String list(Model model){
        model.addAttribute("products", service.retrieveAll());
        return "product/list";
    }

    @RequestMapping("/{id}")
    String show(@PathVariable Long id, Model model){
        model.addAttribute(service.retrieve(id));
        return "product/show";
    }

    @RequestMapping("/add")
    String add(Model model){
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model){
        model.addAttribute("product", service.retrieve(id));
        return "product/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Product product){
        service.create(product);
        return "redirect:/product/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    String update(Product product){
        service.update(product);
        return "redirect:/product/";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/product/";
    }
}
