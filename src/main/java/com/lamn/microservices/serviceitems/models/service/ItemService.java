package com.lamn.microservices.serviceitems.models.service;

import com.lamn.microservices.appcommons.models.entity.Product;
import com.lamn.microservices.serviceitems.models.Item;

import java.util.List;

/**
 * The interface Item service.
 */
public interface ItemService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Item> findAll();

    /**
     * Find by id item.
     *
     * @param id    the id
     * @param count the count
     * @return the item
     */
    Item findById(Long id, Integer count);

    /**
     * Save product.
     *
     * @param product the product
     * @return the product
     */
    Product save(Product product);

    /**
     * Update product.
     *
     * @param product the product
     * @param id      the id
     * @return the product
     */
    Product update(Product product, Long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
