package controllers;

import models.User;
import services.NotificationService;

public class NotificationController {
    private NotificationService notificationService = new NotificationService();

    public void sendBidPlacedNotification(User user, String artworkTitle) {
        String message = "Your bid on '" + artworkTitle + "' has been successfully placed!";
        notificationService.createAndSendNotification("N" + System.currentTimeMillis(), user, message);
    }

    public void sendAuctionClosedNotification(User user, String artworkTitle) {
        String message = "The auction for '" + artworkTitle + "' has been closed. Check the results!";
        notificationService.createAndSendNotification("N" + System.currentTimeMillis(), user, message);
    }
}
