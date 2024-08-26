package com.bejapastes.projectspringbootbejapasteles.product.services;

import com.bejapastes.projectspringbootbejapasteles.product.modelentity.Product;
import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product save(Product product);
    public Product findById(Long id);
    public void deleteById(Long id);
}
