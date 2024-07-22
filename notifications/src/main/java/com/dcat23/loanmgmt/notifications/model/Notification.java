package com.dcat23.loanmgmt.notifications.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "customer_id")
    private Long customerId; // Reference to the customer in Customer Service

    @Column(nullable = false, name = "message")
    private String message;

    @Column(nullable = false, name = "is_read")
    private Boolean isRead = false;

    @Column(nullable = false, name = "sent_date")
    private LocalDate notificationDate;


}
