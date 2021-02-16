package com.lamn.microservices.serviceitems.clients;

import com.lamn.microservices.appcommons.models.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * The interface Product rest client.
 */
@FeignClient(name = "lanm-service-product")
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

    /**
     * Create product product.
     *
     * @param product the product
     * @return the product
     */
    @PostMapping("/create")
    Product createProduct(@RequestBody Product product);

    /**
     * Update product product.
     *
     * @param product the product
     * @param id      the id
     * @return the product
     */
    @PutMapping("/edit/{id}")
    Product updateProduct(@RequestBody Product product, @PathVariable Long id);

    /**
     * Delete product.
     *
     * @param id the id
     */
    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Long id);

}
