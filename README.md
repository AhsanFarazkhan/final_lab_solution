# Auction System

This is a Java-based auction system project that enables users to create and participate in auctions for artwork. The system is implemented using object-oriented principles and includes functionalities for user registration, artwork management, bidding, notifications, and auction lifecycle management.

---

## **Features**

### **User Features**
- **Registration and Login**: Users can register and log in using their credentials.
- **Bid on Artwork**: Users can place bids on available artwork.
- **View Artworks**: Users can browse the list of available artworks.

### **Artwork Features**
- **Create Artwork**: Artists can create new artwork entries.
- **Update Artwork**: Artists can update descriptions of their artwork.

### **Auction Features**
- **Start Auction**: Auctions can be initiated for specific artwork.
- **Place Bid**: Users can place bids on active auctions.
- **Close Auction**: Auctions can be closed, and the highest bid is displayed.

### **Notification Features**
- **Bid Notification**: Users are notified when they place a bid.
- **Auction Close Notification**: Artists are notified when an auction is closed.

---

## **Project Structure**

The project is organized into the following packages:

### **1. `models`**
Contains the core entities of the system:
- **`User`**: Represents users (e.g., Artists, Collectors).
- **`Artwork`**: Represents artwork available for bidding.
- **`Bid`**: Represents bids placed on artwork.
- **`Auction`**: Manages auction lifecycle and tracks bids.
- **`Notification`**: Represents notifications sent to users.

### **2. `services`**
Contains business logic:
- **`AuctionService`**: Handles auction-specific operations (start, close, place bid).
- **`NotificationService`**: Creates and sends notifications to users.

### **3. `controllers`**
Interfaces between models and services:
- **`AuctionController`**: Manages auction-related operations.
- **`NotificationController`**: Handles notification operations.

### **4. `main`**
Contains the `Main` class to execute the program.

---

## **Requirements**

- **Java Development Kit (JDK)**: Version 8 or higher
- **NetBeans IDE**: For project development and execution

---

## **Setup Instructions**

### **Step 2: Import project into NetBeans**
1. Open NetBeans.
2. Go to `File > Open Project`.

### **Step 3: Run the Application**
1. Right-click on the `Main` class in the `main` package.
2. Select `Run File`.

---
# Project Architecture

The project follows the **Layered Architecture** (also known as N-Tier Architecture):

---

## 1. Presentation Layer

- **Role**:  
  Handles user interactions and acts as an entry point to the system.

- **Implementation**:  
  The `Main` class in the `main` package simulates interactions, such as starting auctions, placing bids, and notifying users.

---

## 2. Controller Layer

- **Role**:  
  Acts as an intermediary between the presentation layer and the business logic. It ensures that user inputs are processed correctly.

- **Implementation**:  
  - `AuctionController`: Handles auction-related interactions like starting or closing auctions and placing bids.  
  - `NotificationController`: Manages sending notifications to users.

---

## 3. Business Logic Layer (Service Layer)

- **Role**:  
  Contains the core functionality and rules of the application.

- **Implementation**:  
  - `AuctionService`: Manages auction operations such as starting, closing, and bid processing.  
  - `NotificationService`: Handles the creation and sending of notifications.

---

## 4. Data Layer (Model Layer)

- **Role**:  
  Represents the core entities and manages data storage.

- **Implementation**:  
  Classes such as `User`, `Artwork`, `Auction`, `Bid`, and `Notification` in the `models` package define the structure of the data and relationships between entities.

---

## Advantages of Layered Architecture

1. **Separation of Concerns**:  
   Each layer is responsible for a specific aspect of the system, making the codebase easier to understand and maintain.

2. **Scalability**:  
   The architecture allows for adding new features or modifying existing ones without impacting other layers.

3. **Testability**:  
   Each layer can be independently tested, improving the quality and reliability of the system.

4. **Reusability**:  
   The services and models can be reused across different parts of the application or other projects.







## **Usage**

### **1. User Registration and Login**
Users can register and log in using the `User` class methods.

### **2. Creating an Auction**
1. Create an `Artwork` object.
2. Initialize an `Auction` object with the artwork.
3. Use the `AuctionController` to start the auction.

### **3. Placing a Bid**
1. Create a `Bid` object.
2. Use the `AuctionController` to place the bid.
3. Notifications will be sent to the bidder.

### **4. Closing an Auction**
1. Use the `AuctionController` to close the auction.
2. Notifications will be sent to the artist.

---


### **Main.java**
```java
package main;

import controllers.AuctionController;
import controllers.NotificationController;
import models.Artwork;
import models.Auction;
import models.Bid;
import models.User;

import java.math.BigDecimal;
import java.util.ArrayList;

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

```

---

## **Contributing**

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -m 'Add feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a pull request.

---

## **License**

This project is licensed under the MIT License. See the `LICENSE` file for details.

