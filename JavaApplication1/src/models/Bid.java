package models;

import java.math.BigDecimal;

public class Bid {
    private String bidId;
    private Artwork artwork;
    private User bidder;
    private BigDecimal bidAmount;
    private long bidTime;

    public Bid(String bidId, Artwork artwork, User bidder, BigDecimal bidAmount, long bidTime) {
        this.bidId = bidId;
        this.artwork = artwork;
        this.bidder = bidder;
        this.bidAmount = bidAmount;
        this.bidTime = bidTime;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public User getBidder() {
        return bidder;
    }
}
