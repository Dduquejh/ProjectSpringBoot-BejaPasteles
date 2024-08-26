package com.bejapastes.projectspringbootbejapasteles.order.modelentity;

import com.bejapastes.projectspringbootbejapasteles.client.modelentity.Client;
import com.bejapastes.projectspringbootbejapasteles.product.modelentity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name="orders")
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column()
    @Getter()
    @Setter()
    private String order_date;

    @Column()
    @Getter()
    @Setter()
    private int quantity;

    @ManyToOne()
    @JoinColumn(name="client_id")
    @Getter()
    @Setter()
    private Client client;


    @ManyToOne()
    @JoinColumn(name="product_id")
    @Getter()
    @Setter()
    private Product product;
}
