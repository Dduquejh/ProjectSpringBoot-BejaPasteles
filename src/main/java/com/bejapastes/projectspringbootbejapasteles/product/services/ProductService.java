package com.bejapastes.projectspringbootbejapasteles.product.services;

import com.bejapastes.projectspringbootbejapasteles.product.modelentity.Product;
import com.bejapastes.projectspringbootbejapasteles.product.dao.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<Product> findProductsWithStock() {
        return productDAO.findProductsWithStock();
    }

}
