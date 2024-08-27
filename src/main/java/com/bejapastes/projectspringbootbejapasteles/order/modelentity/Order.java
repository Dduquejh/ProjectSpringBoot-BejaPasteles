package com.bejapastes.projectspringbootbejapasteles.order.modelentity;

import com.bejapastes.projectspringbootbejapasteles.client.modelentity.Client;
import com.bejapastes.projectspringbootbejapasteles.product.modelentity.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

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
    private LocalDate order_date;

    @Column()
    @Min(value=1 , message="Quantity must be greater than 0")
    @Getter()
    @Setter()
    private int quantity;

    @ManyToOne()
    @JoinColumn(name="client_id")
    @NotNull(message="Client is required")
    @Getter()
    @Setter()
    private Client client;


    @ManyToOne()
    @JoinColumn(name="product_id")
    @NotNull(message="Product is required")
    @Getter()
    @Setter()
    private Product product;
}
