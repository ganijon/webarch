package edu.mum.coffee.service;

import edu.mum.coffee.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductApiService implements ProductService {

    @Autowired
    RestTemplate restTemplate;

    private String apiEndpointUri;

    public ProductApiService(@Value("${api.uri}") String apiUri) {
        this.apiEndpointUri = apiUri + "/product/";
    }


    @Override
    public Product create(Product product) {
        HttpEntity<?> httpEntity = new HttpEntity<Object>(product);
        ResponseEntity<Product> response = restTemplate.postForEntity(
                apiEndpointUri,
                httpEntity,
                Product.class);
        return response.getBody();
    }

    @Override
    public Product retrieve(Long id) {
        ResponseEntity<Product> response = restTemplate.exchange(
                apiEndpointUri + id,
                HttpMethod.GET,
                null,
                Product.class);
        return response.getBody();
    }

    @Override
    public void update(Product product) {
        HttpEntity<?> httpEntity = new HttpEntity<Object>(product);
        restTemplate.put(apiEndpointUri, httpEntity);
    }

    @Override
    public void delete(Long id) {
        try {
            ResponseEntity<Void> response = restTemplate.exchange(
                    apiEndpointUri + id,
                    HttpMethod.DELETE,
                    null,
                    Void.class);
        } catch (Exception ex) {
            //logger.log(ex);
        }
    }

    @Override
    public List<Product> retrieveAll() {
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                apiEndpointUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });
        return response.getBody();
    }
}
