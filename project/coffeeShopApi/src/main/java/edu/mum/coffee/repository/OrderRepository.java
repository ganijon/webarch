package edu.mum.coffee.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> findDistinctOrderByOrderLines_Product(Product product);
	List<Order> findOrderByOrderDateBetween(Date minDate, Date maxDate);
	List<Order> findOrderByPerson(Person person);
}
