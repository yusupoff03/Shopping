package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.product.Product;
import org.example.model.product.ProductStatus;
import org.example.service.product.ProductService;
import org.example.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @RequestMapping(value = "/add-product/{userId}", method = RequestMethod.GET)
    public String addProductGet(@PathVariable UUID userId, Model model) {
        model.addAttribute(userId);
        return "addProduct";
    }

    @RequestMapping(value = "/add-product/{userId}", method = RequestMethod.POST)
    public String addProduct(@PathVariable UUID userId, @ModelAttribute Product product,
                             Model model) {
        product.setIsActive(ProductStatus.ACTIVE);
        if (productService.add(product, userId) == 1) {
            model.addAttribute("user", userService.getById(userId));
            return "menu";
        }
        model.addAttribute("message", "You already add this model of product");
        model.addAttribute("userId",userId);
        return "addProduct";
    }

    @RequestMapping(value = "/products-list/{id}")
    public String showGet(@PathVariable UUID id, Model model) {
        if (productService.getUserProducts(id) == null) {
            model.addAttribute("message", "You don`t have a product!!! Please add new product for show your products");
            model.addAttribute("user", userService.getById(id));
            return "menu";
        }
        model.addAttribute("userId", id);
        model.addAttribute("products", productService.getUserProducts(id));
        return "products";
    }

    @RequestMapping(value = "/products/delete/{userId}")
    public String delete(@PathVariable UUID userId, @RequestParam UUID productId, Model model) {
        productService.delete(productId);
        model.addAttribute("user", userService.getById(userId));
        return "menu";
    }

    @RequestMapping(value = "products/edit/{userId}", method = RequestMethod.GET)
    public String editGet(@PathVariable UUID userId, @RequestParam UUID productId, @RequestParam List<Product> products, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("productId", productId);
        model.addAttribute("products", products);
        return "edit";
    }

    @RequestMapping(value = "products/edit/{userId}", method = RequestMethod.POST)
    public String edit(@PathVariable UUID userId, @RequestParam UUID productId,
                       @RequestParam String type,
                       @RequestParam String manufacturer,
                       @RequestParam String model,
                       @RequestParam Double balance,
                       @RequestParam Integer amount, Model model1) {
        Product product = new Product();
        product.setType(type);
        product.setManufacturer(manufacturer);
        product.setModel(model);
        product.setBalance(balance);
        product.setAmount(amount);
        productService.edit(product, productId);
        model1.addAttribute("userId", userId);
        return "products";
    }
    @RequestMapping(value = "/all-products/{userId}")
    public String getAll(@PathVariable UUID userId,Model model){
        model.addAttribute("userId",userId);
        model.addAttribute("products",productService.getALL());
        return "getAll";
    }

}
