package com.aishop.backend.controller;

import com.aishop.backend.dto.ProductForm;
import com.aishop.backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("product", new ProductForm());
        return "products/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("product") ProductForm form) {
        productService.create(form);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        var product = productService.findById(id);
        ProductForm form = new ProductForm();
        form.setId(product.getId());
        form.setName(product.getName());
        form.setCategory(product.getCategory());
        form.setPrice(product.getPrice());
        form.setStock(product.getStock());
        form.setAiRecommendScore(product.getAiRecommendScore());
        form.setDescription(product.getDescription());
        model.addAttribute("product", form);
        return "products/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute("product") ProductForm form) {
        productService.update(id, form);
        return "redirect:/products";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
