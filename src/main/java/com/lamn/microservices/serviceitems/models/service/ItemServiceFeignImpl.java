package com.lamn.microservices.serviceitems.models.service;

import com.lamn.microservices.appcommons.models.entity.Product;
import com.lamn.microservices.serviceitems.clients.ProductRestClient;
import com.lamn.microservices.serviceitems.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Item service feign.
 */
@Service("itemServiceFeign")
@Primary
public class ItemServiceFeignImpl implements ItemService {

    @Autowired
    private ProductRestClient productRestClient;

    @Override
    public List<Item> findAll() {
        List<Product> products = productRestClient.getAllProducts();

        return products != null ?
                products.stream().map(product -> new Item(product, 1)).collect(Collectors.toList()) :
                new ArrayList<>();
    }

    @Override
    public Item findById(Long id, Integer count) {
        Product product = productRestClient.getProduct(id);
        return product != null ? new Item(product, count) : null;
    }

    @Override
    public Product save(Product product) {
        return productRestClient.createProduct(product);
    }

    @Override
    public Product update(Product product, Long id) {
        return productRestClient.updateProduct(product, id);
    }

    @Override
    public void deleteById(Long id) {
        productRestClient.deleteProduct(id);
    }
}
