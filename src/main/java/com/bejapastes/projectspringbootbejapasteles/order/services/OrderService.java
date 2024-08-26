package com.bejapastes.projectspringbootbejapasteles.order.services;

import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import com.bejapastes.projectspringbootbejapasteles.order.dao.IOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderDAO orderDAO;

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public Order save(Order order) {
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
}
