package com.example.demosoapclient.controller;

import com.example.demosoapclient.myService.MyService;
import com.example.demosoapclient.service.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Calendar;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    MyService myService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("products", myService.studentService().getAllProducts());
        return "index";
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/create";
        }
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        myService.studentService().addProduct(product);
        return "redirect:/products";
    }

    @RequestMapping(value = "/sell", method = RequestMethod.GET)
    public String sell(Model model) {
        model.addAttribute("products", myService.studentService().getAllProducts());
        return "sell";
    }

}
