package edu.mum.coffee.service;

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
public class PersonApiService implements PersonService {

    @Autowired
    RestTemplate restTemplate;

    private String apiEndpointUri;

    public PersonApiService(@Value("${api.uri}") String apiUri) {
        this.apiEndpointUri = apiUri + "/person/";
    }

    @Override
    public Person create(Person person) {
        HttpEntity<?> httpEntity = new HttpEntity<Object>(person);
        ResponseEntity<Person> response = restTemplate.postForEntity(
                apiEndpointUri,
                httpEntity,
                Person.class);
        return response.getBody();
    }

    @Override
    public Person retrieve(Long id) {
        ResponseEntity<Person> response = restTemplate.exchange(
                apiEndpointUri + id,
                HttpMethod.GET,
                null,
                Person.class);
        return response.getBody();
    }

    @Override
    public void update(Person person) {
        HttpEntity<?> httpEntity = new HttpEntity<Object>(person);
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
    public List<Person> retrieveAll() {
        ResponseEntity<List<Person>> response = restTemplate.exchange(
                apiEndpointUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Person>>() {
                });
        return response.getBody();
    }

    @Override
    public Person findByEmail(String email) {
        String requestUri = UriComponentsBuilder.fromHttpUrl(apiEndpointUri)
                .path("find").queryParam("email", URLEncoder.encode(email))
                .build().toUriString();

        ResponseEntity<Person> response = restTemplate.exchange(
                requestUri,
                HttpMethod.GET,
                null,
                Person.class
        );
        return response.getBody();
    }
}
