package edu.mum.coffee.service;

import edu.mum.coffee.domain.Product;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductApiService implements ProductService {

    @Value("${api.hostName}")
    private String apiHostName;

    @Value("${api.hostPort}")
    private String apiHostPort;

    @Value("${api.userName}")
    private String apiUserName;

    @Value("${api.secret}")
    private String apiSecret;

    private HttpHeaders httpHeaders;
    private String apiUri;

    @PostConstruct
    private void init() {
        String plainCreds = apiUserName + ":" + apiSecret;
        String base64Creds = Base64.encodeBase64String(plainCreds.getBytes());

        httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic " + base64Creds);

        apiUri = "http://" + apiHostName + ":" + apiHostPort + "/api" + "/product/";
    }


    @Override
    public Product create(Product product) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> httpEntity = new HttpEntity<Object>(product, httpHeaders);
        ResponseEntity<Product> response = restTemplate.postForEntity(
                apiUri,
                httpEntity,
                Product.class);
        return response.getBody();
    }

    @Override
    public Product retrieve(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> response = restTemplate.exchange(
                apiUri + id,
                HttpMethod.GET,
                new HttpEntity<String>(httpHeaders),
                Product.class);
        return response.getBody();
    }

    @Override
    public void update(Product product) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> httpEntity = new HttpEntity<Object>(product, httpHeaders);
        restTemplate.put(apiUri, httpEntity);
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();

        //restTemplate.delete(apiUri + id);

        try {
            ResponseEntity<Void> response = restTemplate.exchange(
                    apiUri + id,
                    HttpMethod.DELETE,
                    new HttpEntity<String>(httpHeaders),
                    Void.class);
        }catch (Exception ex) {
            //logger.log(ex);
        }
    }


    @Override
    public List<Product> retrieveAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                apiUri,
                HttpMethod.GET,
                new HttpEntity<String>(httpHeaders),
                new ParameterizedTypeReference<List<Product>>() {
                });
        return response.getBody();
    }
}
