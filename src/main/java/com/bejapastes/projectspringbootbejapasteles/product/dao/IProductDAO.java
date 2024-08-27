package com.bejapastes.projectspringbootbejapasteles.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bejapastes.projectspringbootbejapasteles.product.modelentity.Product;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IProductDAO extends JpaRepository<Product, Long> {
    @Query ("SELECT p FROM Product p WHERE p.stock > 0")
    public List<Product> findProductsWithStock();
}
