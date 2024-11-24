package app.controllers;

import app.Repository.ProductRepo;
import app.Services.UploadService;
import app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    UploadService uploadService;

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/admin/ajouterproduct")
    String ajouterProduct(Model model) {
        model.addAttribute("product", new Product());
        return "ajouterproduct";
    }

    @PostMapping(value = "admin/ajouterproduct")
    String ajouterproduct(@ModelAttribute("product") Product product, @RequestParam("image2") MultipartFile file) throws IOException {

        String storageFileName = uploadService.upload(file);
        product.setImage(storageFileName);
        productRepo.save(product);
        System.out.println(product.getDescription());
        System.out.println(file.getOriginalFilename());

        return "index";
    }


}
