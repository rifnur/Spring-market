package ru.geekbrains.persist.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
            (length = 150, nullable = false)
    private String title;

    @Column
            (length = 255, nullable = false)
    private String description;

    @Column
            ( nullable = false)
    private BigDecimal price;

    @ManyToOne(optional = false)
    private Category category;

    public Product() {
    }

    public Product(Long id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;    }

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
