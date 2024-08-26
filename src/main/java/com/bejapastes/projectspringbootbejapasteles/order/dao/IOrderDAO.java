package com.bejapastes.projectspringbootbejapasteles.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;

public interface IOrderDAO extends JpaRepository<Order, Long> {
}
