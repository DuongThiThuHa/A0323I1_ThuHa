package org.example.hannahotel.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hannahotel.model.Room;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingResponse {
    private Long bookingsId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;
    private String guestEmail;
    private int NumOfAdults;
    private int NumOfChildren;
    private int totalNumOfGuest;
    private String bookingConfirmationCode;
    private Room room;

    public BookingResponse(Long bookingsId, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfirmationCode) {
        this.bookingsId = bookingsId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }


}
