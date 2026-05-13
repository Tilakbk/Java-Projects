package com.tilak.EcomNepalBackend.Service;

import com.tilak.EcomNepalBackend.Model.Product;
import com.tilak.EcomNepalBackend.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository p)
    {
        productRepository=p;
    }

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }


    public Product addProduct(Product p, MultipartFile imageFile) throws IOException {

        p.setImageData(imageFile.getBytes());
        p.setImageType(imageFile.getContentType());
        p.setImageName(imageFile.getOriginalFilename());

        return productRepository.save(p);
    }


}
