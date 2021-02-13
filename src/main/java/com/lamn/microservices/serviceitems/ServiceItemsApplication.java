package com.lamn.microservices.serviceitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type Service items application.
 */
@EnableFeignClients
@SpringBootApplication
public class ServiceItemsApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ServiceItemsApplication.class, args);
    }

}
