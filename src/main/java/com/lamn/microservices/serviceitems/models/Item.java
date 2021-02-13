package com.lamn.microservices.serviceitems.models;

/**
 * The type Item.
 */
public class Item {

    private Product product;
    private Integer count;

    /**
     * Instantiates a new Item.
     */
    public Item() {
    }

    /**
     * Instantiates a new Item.
     *
     * @param product the product
     * @param count   the count
     */
    public Item(Product product, Integer count) {
        this.product = product;
        this.count = count;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets product.
     *
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public Double getTotal() {
        return product != null ? product.getPrice() * count.doubleValue() : 0;
    }
}
