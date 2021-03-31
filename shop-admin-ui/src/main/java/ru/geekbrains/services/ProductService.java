package ru.geekbrains.services;


import org.springframework.data.domain.Page;
import ru.geekbrains.info.ProductInfo;
import ru.geekbrains.persist.model.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<ProductInfo> findWithFilter(Optional<String> nameFilter,
                                     Optional<BigDecimal> minPrice,
                                     Optional<BigDecimal> maxPrice,
                                     Optional<Integer> page,
                                     Optional<Integer> size,
                                     Optional<String> sortField,
                                     Optional<String> sortOrder);
    List<ProductInfo> findAll();

    Optional<ProductInfo> findById(Long id);

    void save(ProductInfo product);

    void deleteById(long id);

    List<Category> findAllCategories();

    Optional<Category> findCategoryById(Long id);

    void saveCategory(Category category);

    void deleteCategory(Long id);


}
