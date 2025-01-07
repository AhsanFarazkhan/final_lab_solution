package models;

public class User {
    private String userId;
    private String username;
    private String email;
    private String password;
    private String userType;

    public User(String userId, String username, String email, String password, String userType) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public void register() {
        System.out.println(username + " registered successfully.");
    }

    public boolean login(String inputEmail, String inputPassword) {
        return this.email.equals(inputEmail) && this.password.equals(inputPassword);
    }

    public void bid(Artwork artwork, double amount) {
        System.out.println(username + " placed a bid of $" + amount + " on artwork: " + artwork.getTitle());
    }

    public void viewArtworks() {
        System.out.println("Displaying artworks...");
    }

    public String getUsername() {
        return username;
    }
}
