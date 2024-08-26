package com.bejapastes.projectspringbootbejapasteles.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bejapastes.projectspringbootbejapasteles.product.modelentity.Product;

public interface IProductDAO extends JpaRepository<Product, Long> {
}
