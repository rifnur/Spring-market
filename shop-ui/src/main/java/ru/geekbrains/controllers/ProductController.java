package ru.geekbrains.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.controllers.repr.ProductRepr;
import ru.geekbrains.services.ProductService;


@Controller
@RequestMapping("/catalog")
public class ProductController
{

  private ProductService productService;


  @Autowired
  @Qualifier("productService")
  public void setProductService(ProductService productService)
  {
      productService = productService;
  }


  @GetMapping("")
  public String getAllProducts(Model model)
  {
	model.addAttribute("products", productService.findAllProducts());
	model.addAttribute("categories", productService.findAllCategories());

	return "catalog";
  }


  @GetMapping("/{id}")
  public String getProduct(@PathVariable("id") Long id, Model model)
  {
	ProductRepr productRepr = productService.findProductById(id)
								 .orElseThrow(IllegalArgumentException::new);
	model.addAttribute("product", productRepr);

	return "product_details";
  }


  @GetMapping("/category/{id}")
  public String getProductsInCategory(@PathVariable("id") Long id, Model model)
  {
	model.addAttribute("products", productService.findProductsByCategory(id));

	return "catalog";
  }

}