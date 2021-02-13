package com.lamn.microservices.serviceitems.controllers;

import com.lamn.microservices.serviceitems.models.Item;
import com.lamn.microservices.serviceitems.models.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/items/{id}/count/{count}")
    public Item getItemDetail(@PathVariable Long id, @PathVariable Integer count) {
        return itemService.findById(id, count);
    }

}
