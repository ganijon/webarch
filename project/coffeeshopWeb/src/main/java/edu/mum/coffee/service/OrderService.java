package edu.mum.coffee.service;

import edu.mum.coffee.domain.Order;

import java.util.List;

public interface OrderService {
    Order create(Order order);
    Order retrieve(Long id);
    void update(Order order);
	void delete(Long id);
    List<Order> retrieveAll();
}
