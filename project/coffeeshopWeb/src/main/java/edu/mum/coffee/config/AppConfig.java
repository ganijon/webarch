package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder,
                                     @Value("${api.uri}") String apiUri,
                                     @Value("${api.key}") String apiKey,
                                     @Value("${api.secret}") String apiSecret) {
        return builder
                .rootUri(apiUri)
                .basicAuthorization(apiKey, apiSecret)
                .build();
    }

    @Bean
    public DriverManagerDataSource dataSource(@Value("${spring.datasource.url}") String dsUrl,
                                              @Value("${spring.datasource.username}") String dsUserName,
                                              @Value("${spring.datasource.password}") String dsPassword) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl(dsUrl);
        driverManagerDataSource.setUsername(dsUserName);
        driverManagerDataSource.setPassword(dsPassword);
        return driverManagerDataSource;
    }
}