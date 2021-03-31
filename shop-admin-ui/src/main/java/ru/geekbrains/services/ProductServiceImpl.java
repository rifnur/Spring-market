package ru.geekbrains.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.info.ProductInfo;
import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.repo.CategoryRepository;
import ru.geekbrains.persist.repo.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ProductServiceImpl implements ru.geekbrains.services.ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    @Autowired
    @Qualifier("productRepository")
    public void setProductRepository(ProductRepository pr)
    {
        productRepository = pr;
    }


    @Autowired
    @Qualifier("categoryRepository")
    public void setCategoryRepository(CategoryRepository cr)
    {
        categoryRepository = cr;
    }

    @Override
    public Page<ProductInfo> findWithFilter(Optional<String> nameFilter, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice, Optional<Integer> page, Optional<Integer> size, Optional<String> sortField, Optional<String> sortOrder) {
        return null;
    }

    @Override
    @Transactional
    public List<ProductInfo> findAll() {
        return productRepository.findAll().stream()
                .map(ProductInfo::new)
                .collect(toList());
    }

    @Override
    @Transactional
    public Optional<ProductInfo> findById(Long id) {
        return productRepository.findById(id).map(ProductInfo::new);
    }

    @Override
    public void save(ProductInfo productInfo) {

    }
    @Override
    @Transactional
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Category> findAllCategories() {
        return null;
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return Optional.empty();
    }

    @Override
    public void saveCategory(Category category) {

    }

    @Override
    public void deleteCategory(Long id) {

    }
}
