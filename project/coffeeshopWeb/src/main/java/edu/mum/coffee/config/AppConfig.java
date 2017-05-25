package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate apiRestTemplate(RestTemplateBuilder builder,
                                        @Value("${api.uri}") String apiUri,
                                        @Value("${api.secret}") String apiSecret,
                                        @Value("${api.userName}") String apiUserName) {
        return builder
                .rootUri(apiUri)
                .basicAuthorization(apiUserName, apiSecret)
                .build();
    }

}