package com.bejapastes.projectspringbootbejapasteles.client.modelentity;

import com.bejapastes.projectspringbootbejapasteles.order.modelentity.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name="clients")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    @Column()
    @Getter()
    @Setter()
    private String name;

    @Column()
    @Getter()
    @Setter()
    private String address;

    @Column()
    @Getter()
    @Setter()
    private String email;

    @Column()
    @Getter()
    @Setter()
    private String phone;

    @OneToMany(mappedBy="client", cascade = CascadeType.ALL)
    private List<Order> orders;
}
