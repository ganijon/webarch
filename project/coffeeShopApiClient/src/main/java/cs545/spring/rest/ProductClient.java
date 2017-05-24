package cs545.spring.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductClient {

    public static HttpHeaders BASIC_AUTH_HTTP_HEADERS;
    public static String REST_API_URI;

    public static void getAllProducts() {

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> requestEntity = new HttpEntity<String>(BASIC_AUTH_HTTP_HEADERS);

        ResponseEntity<String> response
                = restTemplate.exchange(REST_API_URI + "/product/", HttpMethod.GET, requestEntity, String.class);

        System.out.println(response);
    }

    public static void getProduct() {

        long id = 1;

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> requestEntity = new HttpEntity<String>(BASIC_AUTH_HTTP_HEADERS);

        ResponseEntity<String> response
                = restTemplate.exchange(REST_API_URI + "/product/" + id, HttpMethod.GET, requestEntity, String.class);

        System.out.println(response);
    }

    public static void addProduct() {

        // TODO: OOPS, I AM GONNA NEED DOMAIN MODELS HERE
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> requestEntity = new HttpEntity<String>(BASIC_AUTH_HTTP_HEADERS);

        ResponseEntity<String> response
                = restTemplate.exchange(REST_API_URI + "/product/" + 1, HttpMethod.GET, requestEntity, String.class);

        System.out.println(response);
    }
}
