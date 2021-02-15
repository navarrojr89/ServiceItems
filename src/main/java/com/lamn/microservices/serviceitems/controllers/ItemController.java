package com.lamn.microservices.serviceitems.controllers;

import com.lamn.microservices.serviceitems.models.Item;
import com.lamn.microservices.serviceitems.models.Product;
import com.lamn.microservices.serviceitems.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Item controller.
 */
@RestController
public class ItemController {

    private static final Logger LOG = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    @Qualifier("itemServiceFeign")
    private ItemService itemService;

    /**
     * Gets all items.
     *
     * @return the all items
     */
    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    /**
     * Gets item detail.
     *
     * @param id    the id
     * @param count the count
     * @return the item detail
     */
    @HystrixCommand(fallbackMethod = "getFallbackItem")
    @GetMapping("/items/{id}/count/{count}")
    public Item getItemDetail(@PathVariable Long id, @PathVariable Integer count) {
        return itemService.findById(id, count);
    }

    private Item getFallbackItem(Long id, Integer count) {
        Product product = new Product();
        product.setId(id);
        product.setName("Not found product");
        product.setPrice(0.0);

        Item item = new Item();
        item.setProduct(product);
        item.setCount(count);

        return item;
    }

    /**
     * Obtain config response entity.
     *
     * @param configText the config text
     * @param serverPort the server port
     * @return the response entity
     */
    @GetMapping("/obtain-config")
    public ResponseEntity<?> obtainConfig(@Value("${configuration.text}") String configText, @Value("${server.port}") String serverPort) {
        LOG.info("Text [{}] and Port [{}]", configText, serverPort);
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("configText", configText);
        jsonMap.put("serverPort", serverPort);
        return new ResponseEntity<>(jsonMap, HttpStatus.OK);
    }

}
