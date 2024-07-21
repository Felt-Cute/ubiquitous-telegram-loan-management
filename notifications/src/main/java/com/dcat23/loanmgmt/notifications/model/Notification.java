package com.dcat23.loanmgmt.notifications.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "transactions")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @Column(nullable = false, name = "customer_id")
    private Long customerId; // Reference to the customer in User Service

    @Column(nullable = false, name = "message")
    private String message;

    @Column(nullable = false, name = "is_read")
    private Boolean isRead;

    @Column(nullable = false, name = "notification_date")
    private LocalDate notificationDate;


}
