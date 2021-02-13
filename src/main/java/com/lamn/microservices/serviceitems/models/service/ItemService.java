package com.lamn.microservices.serviceitems.models.service;

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

}
