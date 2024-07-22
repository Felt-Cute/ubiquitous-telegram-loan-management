package com.dcat23.loanmgmt.notifications.controller;

import com.dcat23.loanmgmt.notifications.dto.NotificationCreationDTO;
import com.dcat23.loanmgmt.notifications.model.Notification;
import com.dcat23.loanmgmt.notifications.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Notification",
        description = "REST APIs to CREATE, UPDATE, FETCH and DELETE Notifications")
@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    @Operation(
                summary = "Create Notification",
                description = "REST API to create a new Notification")
    @ApiResponse(
                responseCode = "201",
                description = "HTTP Status CREATED")
    public ResponseEntity<Notification> createNotification(@Valid @RequestBody NotificationCreationDTO notificationDTO) {
        Notification savedNotification = notificationService.createNotification(notificationDTO);
        return ResponseEntity.ok(savedNotification);
    }

    @GetMapping("/customer/{customerId}")
    @Operation(
                summary = "Get Notifications By Customer Id",
                description = "REST API to list all Notifications for a Customer")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<List<Notification>> getNotificationsByUserId(@PathVariable Long customerId) {
        List<Notification> notifications = notificationService.getNotificationsByUserId(customerId);
        return ResponseEntity.ok(notifications);
    }

    @PutMapping("/{notificationId}/read")
    @Operation(
                summary = "Mark Notification As Read",
                description = "REST API to mark a notification as READ")
    public ResponseEntity<Notification> markNotificationAsRead(@PathVariable Long notificationId) {
        Notification updatedNotification = notificationService.markNotificationAsRead(notificationId);
        return ResponseEntity.ok(updatedNotification);
    }

    @DeleteMapping("/{notificationId}")
    @Operation(
                summary = "Delete Notification",
                description = "REST API to delete a Notification")
    @ApiResponse(
                responseCode = "204",
                description = "HTTP Status NO CONTENT")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long notificationId) {
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}

