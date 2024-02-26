package com.example.webmarket.product.controller;

import com.example.webmarket.product.dto.ProductDto;
import com.example.webmarket.product.entity.Product;
import com.example.webmarket.product.repository.ProductRepository;
import com.example.webmarket.product.service.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/listProduct")
    public String showExampleView(Model model){
        List<Product> products=productRepository.findAll();
        model.addAttribute("products",products);
        return "/listProduct";
    }



//    @GetMapping("/addProduct")
//    public String showAddProduct(Model model) throws IOException {
//        Product product=new Product();
//        model.addAttribute("product", product);
//        return "/addProduct";
//    }


//    @PostMapping(  "/addProduct")
//    public String saveProduct(@RequestParam("name") String name,
//                              @RequestParam("price") Integer price,
//                              @RequestParam("amount") Integer amount,
//                              @RequestParam("fileName") MultipartFile file,
//                              RedirectAttributes redirectAttributes) {
//
//            Product product = new Product();
//            product.setName(name);
//            product.setPrice(price);
//            product.setAmount(amount);
//            productService.saveProduct(product);
//
//
//        return "redirect:/listProduct";
//    }

    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productRepository.deleteById(id);
        return "redirect:/listProduct";
    }
    @PostMapping("/changePrice")
    public String changeProductPrice(@RequestParam ("id") Long id,@RequestParam("price")Integer price){
        Product product=new Product();
        product=productRepository.findById(id).get();
        product.setPrice(price);
        productRepository.save(product);
        return "redirect:/listProduct";
    }
    @PostMapping("/changeAmount")
    public String changeProductAmount(@RequestParam ("id") Long id,@RequestParam("amount")Integer amount){
        Product product=new Product();
        product=productRepository.findById(id).get();
        product.setAmount(amount);
        productRepository.save(product);
        return "redirect:/listProduct";
    }
    @PostMapping("/changeName")
    public String changeProductName(@RequestParam ("id") Long id,@RequestParam("name")String name){
        Product product=new Product();
        product=productRepository.findById(id).get();
        product.setName(name);
        productRepository.save(product);
        return "redirect:/listProduct";
    }
    @PostMapping("/changeImage")
    public String changeProductImage(@RequestParam ("id") Long id,@RequestParam("file") MultipartFile file){
        Product product=new Product();
        product=productRepository.findById(id).get();
        productRepository.save(product);
        return "redirect:/listProduct";
    }

}
