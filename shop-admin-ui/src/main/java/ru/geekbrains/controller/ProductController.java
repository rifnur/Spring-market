package ru.geekbrains.controller;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.info.ProductInfo;
import ru.geekbrains.services.ProductService;
import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public String listPage(Model model) {
        logger.info("List page requested");

        model.addAttribute("product", productService.findAll());
          return "product";
    }

    @GetMapping("/{id}")
    public String editProduct(@PathVariable(value = "id") Long id, Model model) {
        logger.info("Edit page for id {} requested", id);
        model.addAttribute("product", productService.findById(id));

//                .orElseThrow(NotFoundException::new));
        model.addAttribute("categories", productService.findAll());
        return "product_form";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid ProductInfo productInfo, BindingResult bindingResult) {
        logger.info("Update endpoint requested");

        if (bindingResult.hasErrors()) {
            return "product_form";
        }
        logger.info("Updating product with id {}", productInfo.getId());
        productService.save(productInfo);
        return "redirect:/product";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        logger.info("Create new product request");
        model.addAttribute( "product",new ProductInfo());
        model.addAttribute("categories", productService.findAll());
        return "product_form";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(value = "id") Long id) {
        logger.info("Product delete request");

        productService.deleteById(id);
        return "redirect:/product";
    }
    @ExceptionHandler
    public ModelAndView notFoundExceptionHandler(NotFoundException ex) {
        ModelAndView mav = new ModelAndView("not_found");
        mav.setStatus(HttpStatus.NOT_FOUND);
        return mav;
    }
}
