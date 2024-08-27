package com.bejapastes.projectspringbootbejapasteles.order.services;

import com.bejapastes.projectspringbootbejapasteles.client.dao.IClientDAO;
import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import com.bejapastes.projectspringbootbejapasteles.order.dao.IOrderDAO;
import com.bejapastes.projectspringbootbejapasteles.product.dao.IProductDAO;
import com.bejapastes.projectspringbootbejapasteles.product.modelentity.Product;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderDAO orderDAO;
    @Autowired
    private IClientDAO clientDAO;
    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Transactional
    @Override
    public Order save(@Valid Order order) {
        if (order.getClient() == null || clientDAO.findById(order.getClient().getClient_id()).isEmpty()) {
            throw new IllegalArgumentException("Client is required");
        }
        if (order.getProduct() == null || productDAO.findById(order.getProduct().getProduct_id()).isEmpty()) {
            throw new IllegalArgumentException("Product is required");
        }

        Product product = productDAO.findById(order.getProduct().getProduct_id())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (product.getStock() < order.getQuantity()) {
            throw new IllegalArgumentException("Quantity exceeds stock");
        }

        product.setStock(product.getStock() - order.getQuantity());
        productDAO.save(product);
        order.setOrder_date(LocalDate.now());
        return orderDAO.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        orderDAO.deleteById(id);
    }

    @Override
    public List<Order> findOrderByClientID(Long client_id) {
        return orderDAO.findOrderByClientID(client_id);
    }
}
