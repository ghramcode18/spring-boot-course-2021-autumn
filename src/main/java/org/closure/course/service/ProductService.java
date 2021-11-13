package org.closure.course.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.closure.course.entity.Product;
import org.closure.course.exception.ProductException;
import org.closure.course.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product addProduct(Product product) throws ProductException{
        if(product.getId() != null) throw new ProductException("can't add product with id");
        return productRepo.save(product.withCreatedAt(Instant.now()));
    }

    public void deleteProduct(Integer id){
        productRepo.deleteById(id);
    }

    public Product updateproduct(Product product){
        return productRepo.save(product);
    }
}
