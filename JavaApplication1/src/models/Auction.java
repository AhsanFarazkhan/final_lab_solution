package models;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    private String auctionId;
    private Artwork artwork;
    private List<Bid> bids;
    private String auctionStatus;

    public Auction(String auctionId, Artwork artwork, List<Bid> bids, String auctionStatus) {
        this.auctionId = auctionId;
        this.artwork = artwork;
        this.bids = (bids != null) ? bids : new ArrayList<>();
        this.auctionStatus = auctionStatus;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setAuctionStatus(String status) {
        this.auctionStatus = status;
    }

    public String getHighestBid() {
        if (bids.isEmpty()) return "No bids yet.";
        return bids.stream()
                .max((b1, b2) -> b1.getBidAmount().compareTo(b2.getBidAmount()))
                .get()
                .getBidAmount()
                .toString();
    }
}
