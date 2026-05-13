package com.tilak.EcomNepalBackend.Controller;

import com.tilak.EcomNepalBackend.Model.Product;
import com.tilak.EcomNepalBackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {


    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService)
    {
        this.productService = productService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> products=productService.getAllProducts();

        if (products!=null)
        {
            return new ResponseEntity<>(products, HttpStatus.OK) ;

        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {

        Product product= productService.getProductById(id);

        if (product!=null)
        {
            return new ResponseEntity<>(product,HttpStatus.OK) ;

        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
