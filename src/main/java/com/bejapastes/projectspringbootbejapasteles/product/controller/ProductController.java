package com.bejapastes.projectspringbootbejapasteles.product.controller;

import com.bejapastes.projectspringbootbejapasteles.product.modelentity.Product;
import com.bejapastes.projectspringbootbejapasteles.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController()
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product == null){
            return createErrorResponse("Product not found", 404);
        }
        return ResponseEntity.status(200).body(product);
    }

    @PostMapping()
    public ResponseEntity<?> postProduct(@RequestBody Product product){
        try{
            productService.save(product);
            return ResponseEntity.status(201).body(product);
        }catch (Exception e){
            return createErrorResponse(e.getMessage(), 500);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id){
        Product productDB = productService.findById(id);
        if(productDB == null){
            throw new RuntimeException("Product not found");
        }
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setPrice(product.getPrice());
        productDB.setStock(product.getStock());
        return productService.save(productDB);
    }

    private ResponseEntity<Map<String, String>> createErrorResponse(String message, int status) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.status(status).body(response);
    }
}
