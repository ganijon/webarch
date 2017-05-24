package edu.mum.coffee.api;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
        Product existingProduct = productService.getProduct(product.getId());

        if (existingProduct == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            productService.save(product);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product existingProduct = productService.getProduct(id);

        if (existingProduct == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(existingProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        Product existingProduct = productService.getProduct(id);
        if (existingProduct == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            productService.delete(existingProduct);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }
}
