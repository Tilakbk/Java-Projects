package com.tilak.EcomNepalBackend.Controller;

import com.tilak.EcomNepalBackend.Model.Product;
import com.tilak.EcomNepalBackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        if (products != null) {
            return new ResponseEntity<>(products, HttpStatus.OK);

        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {

        Product product = productService.getProductById(id);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);

        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        try {
            Product product1 = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id) {
        Product product = productService.getProductById(id);
        byte[] imagefile = product.getImageData();
        return ResponseEntity.ok().body(imagefile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product product1 = null;
        try {
            product1 = productService.updateProduct(id, product, imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>(e, HttpStatus.NO_CONTENT);
        }
        if (product1 != null) {
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        } else
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);


    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {

        Product product=productService.getProductById(id);
        if (product!=null)
        {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);

        }
        else
            return new ResponseEntity<>("Fail to delete",HttpStatus.BAD_REQUEST);

    }
}
