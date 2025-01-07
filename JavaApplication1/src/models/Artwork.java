package models;

import java.math.BigDecimal;

public class Artwork {
    private String artworkId;
    private String title;
    private User artist;
    private String description;
    private BigDecimal startingPrice;
    private BigDecimal currentBid;
    private BigDecimal reservePrice;

    public Artwork(String artworkId, String title, User artist, String description, BigDecimal startingPrice, BigDecimal reservePrice) {
        this.artworkId = artworkId;
        this.title = title;
        this.artist = artist;
        this.description = description;
        this.startingPrice = startingPrice;
        this.reservePrice = reservePrice;
        this.currentBid = startingPrice;
    }

    public void createArtwork() {
        System.out.println("Artwork '" + title + "' created by " + artist.getUsername());
    }

    public void updateArtwork(String newDescription) {
        this.description = newDescription;
        System.out.println("Artwork updated.");
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(BigDecimal bid) {
        this.currentBid = bid;
    }
}
