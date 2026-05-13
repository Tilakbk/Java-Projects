package com.tilak.EcomNepalBackend.Controller;

import com.tilak.EcomNepalBackend.Model.Product;
import com.tilak.EcomNepalBackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {


    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String greet()
    {
        return "Hello";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {

        return productService.getAllProducts();
    }

//    @GetMapping("/products/{id}")
//    public Product getProductById(int id)
//    {
//        return productService.getProductById(id);


//    @PostMapping("/addroduct")
}
