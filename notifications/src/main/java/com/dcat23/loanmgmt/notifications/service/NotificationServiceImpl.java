package com.dcat23.loanmgmt.notifications.service;

import com.dcat23.loanmgmt.notifications.dto.NotificationCreationDTO;
import com.dcat23.loanmgmt.notifications.model.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Override
    public Notification createNotification(NotificationCreationDTO notificationDTO) {
        return null;
    }

    @Override
    public List<Notification> getNotificationsByUserId(Long customerId) {
        return List.of();
    }

    @Override
    public Notification markNotificationAsRead(Long id) {
        return null;
    }

    @Override
    public void deleteNotification(Long id) {

    }
}
