package edu.mum.coffee.controllers;

import edu.mum.coffee.model.Order;
import edu.mum.coffee.model.Orderline;
import edu.mum.coffee.model.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    String list(Model model) {
        model.addAttribute("products", service.retrieveAll());
        return "product/list";
    }

    @RequestMapping("/{id}")
    String show(@PathVariable Long id, Model model) {
        model.addAttribute(service.retrieve(id));
        return "product/show";
    }

    @RequestMapping("/add")
    String add(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", service.retrieve(id));
        return "product/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Product product) {
        service.create(product);
        return "redirect:/product/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    String update(Product product) {
        service.update(product);
        return "redirect:/product/";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/product/";
    }

    @RequestMapping(value = "/order/{id}")
    String orderProduct(@PathVariable("id") Long productId, HttpSession session) {

        if (null == session.getAttribute("cart")) {

            Order newOrder = new Order();

            Product orderedProduct = service.retrieve(productId);

            Orderline newOrderline = new Orderline();
            newOrderline.setProduct(orderedProduct);
            newOrderline.setQuantity(1);
            newOrderline.setOrder(newOrder);
            newOrder.addOrderLine(newOrderline);
            session.setAttribute("cart", newOrder);

        } else {

            Order order = (Order) session.getAttribute("cart");

            boolean newProduct = true;
            for (Orderline orderline : order.getOrderLines()) {
                if (productId == orderline.getProduct().getId()) {
                    orderline.setQuantity(1 + orderline.getQuantity());
                    newProduct = false;
                }
            }

            if (newProduct) {

                Product orderedProduct = service.retrieve(productId);

                Orderline newOrderline = new Orderline();
                newOrderline.setProduct(orderedProduct);
                newOrderline.setQuantity(1);
                newOrderline.setOrder(order);
                order.addOrderLine(newOrderline);
            }
        }

        return "redirect:/product/";
    }
}
