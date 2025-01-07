package services;

import models.Notification;
import models.User;

public class NotificationService {
    public void createAndSendNotification(String notificationId, User user, String message) {
        Notification notification = new Notification(notificationId, user, message);
        notification.sendNotification();
    }
}
