package ru.geekbrains.info;

import ru.geekbrains.persist.model.Product;

import java.math.BigDecimal;


public class ProductInfo {

    public Long id;
    public String title;
    public String description;
    public BigDecimal price;
    public String category;



    public ProductInfo(Product product)
    {
        id = product.getId();
        title = product.getTitle();
        description = product.getDescription();
        price = product.getPrice();
        category = product.getCategory().getName();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductInfo()
    {
    }
}
