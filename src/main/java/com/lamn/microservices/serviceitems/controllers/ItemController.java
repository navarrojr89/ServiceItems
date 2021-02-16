package com.lamn.microservices.serviceitems.controllers;

import com.lamn.microservices.serviceitems.models.Item;
import com.lamn.microservices.serviceitems.models.Product;
import com.lamn.microservices.serviceitems.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Item controller.
 */
@RestController
public class ItemController {

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

    /**
     * Create product product.
     *
     * @param product the product
     * @return the product
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return itemService.save(product);
    }

    /**
     * Edit product product.
     *
     * @param product the product
     * @param id      the id
     * @return the product
     */
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product editProduct(@RequestBody Product product, @PathVariable Long id) {
        return itemService.update(product, id);
    }

    /**
     * Delete product.
     *
     * @param id the id
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        itemService.deleteById(id);
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
}
