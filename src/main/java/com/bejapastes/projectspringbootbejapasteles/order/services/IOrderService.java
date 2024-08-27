package com.bejapastes.projectspringbootbejapasteles.order.services;

import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import java.util.List;

public interface IOrderService{
    public Order save(Order order);
    public void deleteById(Long id);
    public Order findById(Long id);
    public List<Order> findAll();
}

