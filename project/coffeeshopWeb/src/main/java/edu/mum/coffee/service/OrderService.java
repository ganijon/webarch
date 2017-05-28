package edu.mum.coffee.service;

import edu.mum.coffee.model.Order;

import java.util.List;

public interface OrderService {
    Order create(Order order);
    void update(Order order);
	void delete(Long id);

    Order findById(Long id);
    List<Order> findAll();
    List<Order> findByPersonEmail(String userEmail);
}
