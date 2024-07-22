package com.dcat23.loanmgmt.notifications.service;

import com.dcat23.loanmgmt.notifications.dto.NotificationCreationDTO;
import com.dcat23.loanmgmt.notifications.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification createNotification(NotificationCreationDTO notificationDTO);

    List<Notification> getNotificationsByUserId(Long customerId);

    Notification markNotificationAsRead(Long id);

    void deleteNotification(Long id);
}
