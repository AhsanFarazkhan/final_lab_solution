package controllers;

import models.Auction;
import models.Bid;
import services.AuctionService;

public class AuctionController {
    private AuctionService auctionService = new AuctionService();

    public void startAuction(Auction auction) {
        auctionService.startAuction(auction);
    }

    public void closeAuction(Auction auction) {
        auctionService.closeAuction(auction);
    }

    public void placeBid(Auction auction, Bid bid) {
        auctionService.placeBid(auction, bid);
    }
}
