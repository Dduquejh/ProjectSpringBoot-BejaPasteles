package com.bejapastes.projectspringbootbejapasteles.product.modelentity;

import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name="products")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Getter()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column()
    @NotBlank(message="Name is required")
    @Size(min=3, message="Name must be at least 3 characters")
    @Getter()
    @Setter()
    private String name;

    @Column()
    @NotNull(message="Price is required")
    @Min(value=10, message="Price must be at least 10")
    @Getter()
    @Setter()
    private Double price;

    @Column()
    @NotBlank(message="Description is required")
    @Size(min=10, message="Description must be at least 10 characters")
    @Getter()
    @Setter()
    private String description;

    @Column()
    @NotNull(message="Stock is required")
    @Min(value=1, message="Stock must be at least 1")
    @Getter()
    @Setter()
    private int stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Order> orders;
}
