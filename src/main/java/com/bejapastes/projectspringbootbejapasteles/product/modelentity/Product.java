package com.bejapastes.projectspringbootbejapasteles.product.modelentity;

import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name="products")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column()
    @Getter()
    @Setter()
    private String name;

    @Column()
    @Getter()
    @Setter()
    private Double price;

    @Column()
    @Getter()
    @Setter()
    private String description;

    @Column()
    @Getter()
    @Setter()
    private int stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Order> orders;
}
