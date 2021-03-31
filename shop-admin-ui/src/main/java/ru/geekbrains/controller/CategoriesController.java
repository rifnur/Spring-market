package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geekbrains.persist.model.Category;
import ru.geekbrains.services.ProductService;


@Controller
@RequestMapping("/categories")
public class CategoriesController
{
    @Autowired
    private ProductService productService;

    @GetMapping
    public String listPage(Model model) {

        model.addAttribute("categories", productService.findAllCategories());
        return "categories";
    }

    @GetMapping("/create")
    public String createCategory(Model model)
    {
        model.addAttribute("create", true);
        model.addAttribute("category", new Category());

        return "category_form";
    }


    @GetMapping("/edit/{id}")
    public String editCategory(Model model, @PathVariable("id") Long id)
    {
        model.addAttribute("edit", true);

        Category cat = productService.findCategoryById(id)
                .orElseThrow(IllegalStateException::new);
        model.addAttribute("category", cat);

        return "category_form";
    }


    @PostMapping("/save")
    public String saveCategory(RedirectAttributes redirAttr, Category category)
    {
        try
        {
            productService.saveCategory(category);
        }
        catch (Exception e)
        {
            redirAttr.addFlashAttribute("error", true);

            if (category.getId() == null)
                return "redirect:/create";

            return "redirect:/edit" + category.getId();
        }

        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id)
    {
        productService.deleteCategory(id);

        return "redirect:/";
    }

}