package org.interview.delivery.service;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Column(name = "delivery_status")
    private String deliveryStatus;
    @Column(name = "delivery_time")
    private Date deliveryTime;
    @Column(name = "created_at")
    private Date createdAt;
}
