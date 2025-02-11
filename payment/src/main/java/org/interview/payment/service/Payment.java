package org.interview.payment.service;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "created_at")
    private Date createdAt;
}
