package edu.mum.coffee.service;

import edu.mum.coffee.model.Order;
import edu.mum.coffee.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.util.List;

@Service
public class OrderApiService implements OrderService {

    @Autowired
    RestTemplate restTemplate;

    private String apiEndpointUri;

    public OrderApiService(@Value("${api.uri}") String apiUri) {
        this.apiEndpointUri = apiUri + "/order/";
    }

    @Override
    public Order create(Order order) {
        HttpEntity<?> httpEntity = new HttpEntity<Object>(order);
        ResponseEntity<Order> response = restTemplate.postForEntity(
                apiEndpointUri,
                httpEntity,
                Order.class);
        return response.getBody();
    }

    @Override
    public void update(Order order) {
        HttpEntity<?> httpEntity = new HttpEntity<Object>(order);
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
    public Order findById(Long id) {
        ResponseEntity<Order> response = restTemplate.exchange(
                apiEndpointUri + id,
                HttpMethod.GET,
                null,
                Order.class);
        return response.getBody();
    }

    @Override
    public List<Order> findAll() {
        ResponseEntity<List<Order>> response = restTemplate.exchange(
                apiEndpointUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Order>>() {
                });
        return response.getBody();
    }

    @Override
    public List<Order> findByPersonEmail(String email) {
        String requestUri = UriComponentsBuilder.fromHttpUrl(apiEndpointUri)
                .path("find").queryParam("email", URLEncoder.encode(email))
                .build().toUriString();

        ResponseEntity<List<Order>> response = restTemplate.exchange(
                requestUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Order>>() {
                }
        );

        return response.getBody();
    }
}
