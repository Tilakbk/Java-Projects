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


    public Product updateProduct(int id, Product updatedProduct, MultipartFile imageFile) throws IOException {

        updatedProduct.setImageName(imageFile.getOriginalFilename());
        updatedProduct.setImageType(imageFile.getContentType());
        updatedProduct.setImageData(imageFile.getBytes());


        return productRepository.save(updatedProduct);


    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchProduct(String keyword) {

        return productRepository.searchProduct(keyword);
    }
}
