package main;

import controllers.AuctionController;
import controllers.NotificationController;
import models.Artwork;
import models.Auction;
import models.Bid;
import models.User;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User artist = new User("U001", "sara", "sara@example.com", "pass123", "Artist");
        User bidder = new User("U002", "farah", "farah@example.com", "pass123", "Collector");
        User bidder2 = new User("U002", "sameer", "sameer@example.com", "pass123", "Collector");
        User bidder3 = new User("U002", "zafar", "zafar@example.com", "pass123", "Collector");
        User bidder4 = new User("U002", "aleem", "aleem@example.com", "pass123", "Collector");
        User bidder5 = new User("U002", "jawad", "jawad@example.com", "pass123", "Collector");
        
        
        Artwork artwork = new Artwork("A001", "Sunset", artist, "Beautiful sunset painting",
                new BigDecimal("100"), new BigDecimal("300"));

        Auction auction = new Auction("AU001", artwork, new ArrayList<>(), "Inactive");

        AuctionController auctionController = new AuctionController();
        NotificationController notificationController = new NotificationController();

        auctionController.startAuction(auction);

        Bid bid = new Bid("B001", artwork, bidder, new BigDecimal("120"), System.currentTimeMillis());
        auctionController.placeBid(auction, bid);
       
        
            Bid bid2 = new Bid("B002", artwork, bidder2, new BigDecimal("125"), System.currentTimeMillis());
        auctionController.placeBid(auction, bid2);
            Bid bid3 = new Bid("B002", artwork, bidder3, new BigDecimal("110"), System.currentTimeMillis());
        auctionController.placeBid(auction, bid3);
            Bid bid4 = new Bid("B002", artwork, bidder4, new BigDecimal("155"), System.currentTimeMillis());
        auctionController.placeBid(auction, bid4);
            Bid bid5 = new Bid("B002", artwork, bidder5, new BigDecimal("160.5"), System.currentTimeMillis());
        auctionController.placeBid(auction, bid5);


        notificationController.sendBidPlacedNotification(bidder, artwork.getTitle());
 notificationController.sendBidPlacedNotification(bidder2, artwork.getTitle());
 notificationController.sendBidPlacedNotification(bidder3, artwork.getTitle());
 notificationController.sendBidPlacedNotification(bidder4, artwork.getTitle());
 notificationController.sendBidPlacedNotification(bidder5, artwork.getTitle());
        auctionController.closeAuction(auction);
        notificationController.sendAuctionClosedNotification(artist, artwork.getTitle());
    }
}
