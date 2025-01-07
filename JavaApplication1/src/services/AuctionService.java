package services;

import models.Auction;
import models.Bid;

public class AuctionService {
    public void startAuction(Auction auction) {
        auction.setAuctionStatus("Active");
        System.out.println("Auction for " + auction.getArtwork().getTitle() + " started.");
    }

    public void closeAuction(Auction auction) {
        auction.setAuctionStatus("Closed");
        System.out.println("Auction closed. Highest bid: $" + auction.getHighestBid());
    }

    public void placeBid(Auction auction, Bid bid) {
        auction.getBids().add(bid);
        System.out.println("Bid of $" + bid.getBidAmount() + " placed by " + bid.getBidder().getUsername());
    }
}
