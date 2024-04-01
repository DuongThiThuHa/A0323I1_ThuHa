package org.example.hannahotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingsId;
    @Column(name = "CheckIn")
    private LocalDate checkInDate;

    @Column(name = "CheckOut")
    private LocalDate checkOutDate;

    @Column(name = "GuestFullName")
    private String guestFullName;

    @Column(name = "GuestEmail")
    private String guestEmail;

    @Column(name = "Adults")
    private int NumOfAdults;

    @Column(name = "Children")
    private int NumOfChildren;

    @Column(name = "TotalGuest")
    private int totalNumOfGuest;

    @Column(name = "ConfirmationCode")
    private String bookingConfirmationCode;

    @JoinColumn(name = "room_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    public void calculateTotalNumberOfGuest() {
        this.totalNumOfGuest = this.NumOfAdults + this.NumOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfChildren(int numOfChildren) {
        NumOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }


}
