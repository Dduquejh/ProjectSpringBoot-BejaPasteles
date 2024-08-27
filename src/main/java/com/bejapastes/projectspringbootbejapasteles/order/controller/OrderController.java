package com.bejapastes.projectspringbootbejapasteles.order.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import com.bejapastes.projectspringbootbejapasteles.order.services.IOrderService;

@RestController()
@RequestMapping("/api/orders")
public class OrderController{
    @Autowired
    private IOrderService orderService;

    @PostMapping()
    public ResponseEntity<?> postOrder(@RequestBody Order order){
        try{
            System.out.println("Order: " + order);
            orderService.save(order);
            return ResponseEntity.status(201).body(order);
        }catch (Exception e){
            return createErrorResponse(e.getMessage(), 500);
        }
    }

    @GetMapping()
    public List<Order> getOrders(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id){
        Order order = orderService.findById(id);
        if(order == null){
            return createErrorResponse("Order not found", 404);
        }
        return ResponseEntity.status(200).body(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteById(id);
    }

    private ResponseEntity<Map<String, String>> createErrorResponse(String message, int status) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.status(status).body(response);
    }
}
