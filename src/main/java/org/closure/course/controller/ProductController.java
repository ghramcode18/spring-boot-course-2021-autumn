package org.closure.course.controller;

import java.util.List;

import org.closure.course.entity.Product;
import org.closure.course.exception.ProductException;
import org.closure.course.model.ErrorMessage;
import org.closure.course.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> allProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) throws ProductException{
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));   
        } catch (ProductException e) {
            ErrorMessage error = new ErrorMessage().withMessage(e.getMessage()).withHashcode("34g5j2k3l45g250248t5g24k3j").withType("SAVE_PRODUCT");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteProduct(@PathVariable(name = "id") Integer pid) {
        productService.deleteProduct(pid);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateproduct(product));
    }

}
