package com.tilak.EcomNepalBackend.Controller;

import com.tilak.EcomNepalBackend.Model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/")
    public String greet()
    {
        return "Hello";
    }

    @GetMapping("/products")
    public List<Product> getProducts()
    {

        return null ;
    }
}
