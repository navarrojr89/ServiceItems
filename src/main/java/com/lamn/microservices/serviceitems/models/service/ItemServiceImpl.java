package com.lamn.microservices.serviceitems.models.service;

import com.lamn.microservices.serviceitems.models.Item;
import com.lamn.microservices.serviceitems.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Item service.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Item> findAll() {
        Product[] productsArray = clientRest.getForObject("http://localhost:10001/products", Product[].class);

        return productsArray != null ?
                Arrays.stream(productsArray).map(product -> new Item(product, 1)).collect(Collectors.toList()) :
                new ArrayList<>();
    }

    @Override
    public Item findById(Long id, Integer count) {
        Map<String, String> variables = new HashMap<>();
        variables.put("id", id.toString());
        Product product = clientRest.getForObject("http://localhost:10001/products/{id}", Product.class, variables);
        return product != null ? new Item(product, count) : null;
    }
}
