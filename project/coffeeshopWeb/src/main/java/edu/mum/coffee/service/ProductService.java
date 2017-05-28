package edu.mum.coffee.service;

import edu.mum.coffee.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product retrieve(Long id);
    void update(Product product);
	void delete(Long id);
    List<Product> retrieveAll();
}
