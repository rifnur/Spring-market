package ru.geekbrains.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.geekbrains.controllers.repr.ProductRepr;
import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.repo.CategoryRepository;
import ru.geekbrains.persist.repo.ProductRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


import static java.util.stream.Collectors.toList;


@Service("productService")
public class ProductServiceImpl
		implements ProductService
{

  private ProductRepository productRepository;
  private CategoryRepository categoryRepo;


  @Autowired
  @Qualifier("productRepository")
  public void setProductRepository(ProductRepository productRepository)
  {
      productRepository = productRepository;
  }


  @Autowired
  @Qualifier("categoryRepository")
  public void setCategoryRepository(CategoryRepository cr)
  {
	categoryRepo = cr;
  }


  @Override
  public Optional<ProductRepr> findProductById(Long id)
  {
	return productRepository.findById(id)
				   .map(ProductRepr::new);
  }


  @Override
  public List<ProductRepr> findAllProducts()
  {
	return productRepository.findAll().stream()
				   .map(ProductRepr::new)
				   .collect(toList());
  }


  @Override
  public List<Category> findAllCategories()
  {
	return categoryRepo.findAll();
  }


  @Override
  public List<ProductRepr> findProductsByCategory(Long id)
  {
	return productRepository.findById(id).stream()
				   .map(ProductRepr::new)
				   .collect(toList());
  }

}