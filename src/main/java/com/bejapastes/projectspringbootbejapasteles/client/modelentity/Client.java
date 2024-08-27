package com.bejapastes.projectspringbootbejapasteles.client.modelentity;

import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name="clients")
public class Client implements Serializable{
    @Id
    @Getter()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    @Column()
    @NotBlank(message="Client name is required")
    @Size(min=5, message="Name must be at least 5 characters")
    @Getter()
    @Setter()
    private String name;

    @Column()
    @Getter()
    @Setter()
    private String address;

    @Column()
    @NotBlank(message="Email is required")
    @Email(message="Email is invalid")
    @Getter()
    @Setter()
    private String email;

    @Column()
    @NotBlank(message="Phone is required")
    @Size(min=10, message="Phone must be at least 10 characters")
    @Pattern(regexp="\\d{10}", message="Phone is invalid")
    @Getter()
    @Setter()
    private String phone;

    @OneToMany(mappedBy="client", cascade = CascadeType.ALL)
    private List<Order> orders;
}
