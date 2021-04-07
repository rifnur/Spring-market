package ru.geekbrains.services;


import ru.geekbrains.controllers.repr.ProductRepr;
import ru.geekbrains.persist.model.Category;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public interface ProductService
		extends Serializable
{

  Optional<ProductRepr> findProductById(Long id);

  List<ProductRepr> findAllProducts();

  List<Category> findAllCategories();

  List<ProductRepr> findProductsByCategory(Long id);

}