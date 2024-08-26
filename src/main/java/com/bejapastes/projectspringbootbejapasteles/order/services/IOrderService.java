package com.bejapastes.projectspringbootbejapasteles.order.services;

import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import java.util.List;

public interface IOrderService {
    public List<Order> findAll();
    public Order save(Order order);
    public Order findById(Long id);
    public void deleteById(Long id);
}
