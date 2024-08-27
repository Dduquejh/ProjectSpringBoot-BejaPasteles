package com.bejapastes.projectspringbootbejapasteles.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IOrderDAO extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.client.client_id = :client_id")
    List<Order> findOrderByClientID(Long client_id);
}
