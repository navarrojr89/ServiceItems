package com.lamn.microservices.serviceitems.clients;

import com.lamn.microservices.serviceitems.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * The interface Product rest client.
 */
@FeignClient(name = "lanm-service-product", url = "localhost:10001")
public interface ProductRestClient {

    /**
     * Gets all products.
     *
     * @return the all products
     */
    @GetMapping("/products")
    List<Product> getAllProducts();

    /**
     * Gets product.
     *
     * @param id the id
     * @return the product
     */
    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id);

}
