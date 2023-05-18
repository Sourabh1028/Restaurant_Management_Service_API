package com.geekster.Restaurant_Management_Service_API.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @OneToOne
    private Food food;

    @OneToOne
    private Restaurant restaurant;

    @ManyToOne
    private User user;

    private Integer orderQuantity;
    @NotNull
    private String userAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
