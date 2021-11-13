package org.closure.course.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.closure.course.dto.ProductDto;
import org.closure.course.entity.Product;
import org.closure.course.exception.ProductException;
import org.closure.course.mapper.ProductMapper;
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

    public ProductDto addProduct(Product product) throws ProductException{
        if(product.getId() != null) throw new ProductException("can't add product with id");
        return ProductMapper.MAPPER.ProductEntityToDto(productRepo.save(product.withCreatedAt(Instant.now())));

    }

    public void deleteProduct(Integer id){
        productRepo.deleteById(id);
    }

    public Product updateproduct(Product product){
        return productRepo.save(product);
    }
}
