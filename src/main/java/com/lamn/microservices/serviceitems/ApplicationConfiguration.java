package com.lamn.microservices.serviceitems;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The type Application configuration.
 */
@Configuration
public class ApplicationConfiguration {

    /**
     * Register rest template rest template.
     *
     * @return the rest template
     */
    @Bean("clientRest")
    @LoadBalanced
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }

}
