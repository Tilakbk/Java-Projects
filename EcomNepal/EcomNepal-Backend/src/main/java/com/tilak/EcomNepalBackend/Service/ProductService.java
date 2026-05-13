package com.tilak.EcomNepalBackend.Service;

import com.tilak.EcomNepalBackend.Model.Product;
import com.tilak.EcomNepalBackend.Repository.ProductRepository;
import org.springframework.stereotype.Service;

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


}
