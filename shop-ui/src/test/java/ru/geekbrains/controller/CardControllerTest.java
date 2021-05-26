package ru.geekbrains.controller;

        import org.hamcrest.BaseMatcher;
        import org.hamcrest.Description;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.ActiveProfiles;
        import org.springframework.test.context.TestPropertySource;
        import org.springframework.test.web.servlet.MockMvc;
        import ru.geekbrains.controller.repr.ProductRepr;
        import ru.geekbrains.persist.model.Brand;
        import ru.geekbrains.persist.model.Category;
        import ru.geekbrains.persist.model.Product;
        import ru.geekbrains.persist.repo.BrandRepository;
        import ru.geekbrains.persist.repo.CategoryRepository;
        import ru.geekbrains.persist.repo.ProductRepository;
        import ru.geekbrains.service.CartService;

        import java.math.BigDecimal;

        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
public class CardControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    public CartService cartService;

    @Test
    public void testDelete() throws Exception {
        Brand brand = brandRepository.save(new Brand("brand"));
        Category category = categoryRepository.save(new Category("Category"));
        Product product = productRepository.save(new Product("Product", new BigDecimal(1234), category, brand));

        mvc.perform(get( product.getId()+"/delete"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("redirect:/cart"));
//                .andExpect(cartService.removeProduct(productRepository., null, null, null, null), "", "");
        //не пришло полное понимание тестирования

    }
}
