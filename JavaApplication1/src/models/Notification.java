package models;

import java.time.LocalDateTime;

public class Notification {
    private String notificationId;
    private User user;
    private String message;
    private LocalDateTime timestamp;

    public Notification(String notificationId, User user, String message) {
        this.notificationId = notificationId;
        this.user = user;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public void sendNotification() {
        System.out.println("Notification sent to " + user.getUsername() + ": " + message);
    }
}
