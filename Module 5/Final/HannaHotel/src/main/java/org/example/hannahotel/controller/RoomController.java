package org.example.hannahotel.controller;

import lombok.RequiredArgsConstructor;
import org.example.hannahotel.exception.PjotoRetrievalException;
import org.example.hannahotel.model.BookedRoom;
import org.example.hannahotel.model.Room;
import org.example.hannahotel.response.BookingResponse;
import org.example.hannahotel.response.RoomResponse;
import org.example.hannahotel.service.BookingsService;
import org.example.hannahotel.service.IRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/rooms")
public class RoomController {
    private final IRoomService roomService;
    private final BookingsService bookingsService;

    @PostMapping("/add/newRoom")
    public ResponseEntity< RoomResponse > addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
        Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/room/roomTypes")
    public List<String> getRoomTypes(){
        return roomService.getAllRoomTypes();
    }

//    public ResponseEntity<List<RoomResponse>> getAllRooms() throws SQLException {
//        List<Room> rooms = roomService.getAllRooms();
//        List<RoomResponse> roomResponses = new ArrayList<>();
//        for (Room room : rooms){
//            byte[] photoBytes = roomService.getRoomPhotoByRoomId(room.getId());
//            if (photoBytes != null && photoBytes.length >0){
//                String base64Photo = Base64.encodeBase64String(photoBytes);
//                RoomResponse roomResponse = getRoomResponse(room);
//                roomResponse.setPhoto(base64Photo);
//                roomResponse.setPhoto(String.valueOf(roomResponse));
//            }
//        }
//        return ResponseEntity.ok(roomResponses);
//    }

    public ResponseEntity<List<RoomResponse>> getAllRooms() throws SQLException {
        List<Room> rooms = roomService.getAllRooms();
        List<RoomResponse> roomResponses = new ArrayList<>();
        for (Room room : rooms){
            byte[] photoBytes = roomService.getRoomPhotoByRoomId(room.getId());
            if (photoBytes != null && photoBytes.length >0){
                RoomResponse roomResponse = getRoomResponse(room);
                roomResponse.setPhoto(Base64.getEncoder().encodeToString(photoBytes));
                roomResponses.add(roomResponse);
            }
        }
        return ResponseEntity.ok(roomResponses);
    }



    private RoomResponse getRoomResponse(Room room) {
        List< BookedRoom > bookings = getAllBookingsByRoomId(room.getId());
        List< BookingResponse > bookingInfo = bookings
                .stream()
                .map(booking -> new BookingResponse(
                        booking.getBookingsId(),
                        booking.getCheckInDate(),
                        booking.getCheckOutDate(),
                        booking.getBookingConfirmationCode())).toList();
        byte[] photoBytes= null;
        Blob photoBlob = room.getPhoto();
        if (photoBlob != null){
            try {
                photoBytes = photoBlob.getBytes(1,(int) photoBlob.length());
            } catch (SQLException e){
                throw new PjotoRetrievalException("Error retrieving photo");
            }
        }

        return new RoomResponse(room.getId(),room.getRoomType(),room.getRoomPrice(),room.isBooked(),photoBytes,bookingInfo);
    }

    private List< BookedRoom> getAllBookingsByRoomId(Long roomId) {
        return bookingsService.getAllBookingsByRoomId(roomId);
    }
}
