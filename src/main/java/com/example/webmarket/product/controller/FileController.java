package com.example.webmarket.product.controller;

import com.example.webmarket.product.entity.Product;
import com.example.webmarket.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.*;
@Controller
public class FileController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("name") String name, @RequestParam("price") Integer price,
                             @RequestParam("amount") Integer amount) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setAmount(amount);
        product.setImage(String.valueOf(file));
        productService.saveProduct(product);

        try {
            byte[] bytes = file.getBytes();

            file.getOriginalFilename();

            String rootPath = "C:\\Users\\Oleg\\OneDrive\\Изображения";
            File dir = new File(rootPath + File.separator + "loadFiles");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File loadFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
            stream.write(bytes);
            stream.flush();
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/listProduct";
    }

    @GetMapping("/addProduct")
    public String showAddProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/addProduct";
    }
}