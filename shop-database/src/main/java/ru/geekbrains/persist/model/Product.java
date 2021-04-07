package ru.geekbrains.persist.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column  (name = "title", length = 150, nullable = false)
    private String title;

    @Column
            (name = "description", length = 255, nullable = false)
    private String description;

    @Column
            (name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne(optional = false)
    private Brand brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Picture> pictures;

    public Product() {
    }

    public Product(Long id, String title, BigDecimal price, Category category, Brand brand) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.brand = brand;}

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) { this.brand = brand;  }

    public List<Picture> getPictures() { return pictures; }

    public void setPictures(List<Picture> pictures) {this.pictures = pictures; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {  return title;    }

    public String getDescription() {  return description; }

    public void setDescription(String description) {  this.description = description;  }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
