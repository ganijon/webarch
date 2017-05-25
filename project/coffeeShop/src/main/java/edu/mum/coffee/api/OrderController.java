package edu.mum.coffee.api;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Order> create(@RequestBody Order order) {
        order = orderService.save(order);
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Order>> retrieveAll() {
        List<Order> orders = orderService.findAll();
        if (orders.isEmpty()) {
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Order> retrieve(@PathVariable Long id) {
        Order existingOrder = orderService.findById(id);

        if (existingOrder == null) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Order>(existingOrder, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Order order) {
        Order existingOrder = orderService.findById(order.getId());

        if (existingOrder == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            orderService.save(order);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Order existingOrder = orderService.findById(id);
        if (existingOrder == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            orderService.delete(existingOrder);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }
}
