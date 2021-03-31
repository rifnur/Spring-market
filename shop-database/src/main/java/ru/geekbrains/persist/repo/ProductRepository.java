package ru.geekbrains.persist.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.model.Product;

@Repository("productRepository")
public interface ProductRepository
        extends JpaRepository<Product, Long>
{



}
