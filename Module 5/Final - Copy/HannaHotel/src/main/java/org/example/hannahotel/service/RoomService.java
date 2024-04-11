package org.example.hannahotel.service;

import lombok.RequiredArgsConstructor;
import org.example.hannahotel.exception.ResourceNotFoundException;
import org.example.hannahotel.model.Room;
import org.example.hannahotel.repository.IRoomRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService{
    private final IRoomRepo roomRepo;
    @Override
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws IOException, SQLException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);

        if (!file.isEmpty()){
            byte[] photoBytes = file.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            room.setPhoto(photoBlob);
        }
        return roomRepo.save(room);
    }

    @Override
    public List< String > getAllRoomTypes() {
        return roomRepo.findDistinctRoomTypes();
    }

    @Override
    public List< Room > getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public byte[] getRoomPhotoByRoomId(Long roomId) throws SQLException {
        Optional<Room> theRoom = roomRepo.findById(roomId);
        if (theRoom.isEmpty()){
            throw new ResourceNotFoundException("Sorry,  Room not found!");
        }

        Blob photoBlob = theRoom.get().getPhoto();
        if (photoBlob != null){
            return photoBlob.getBytes(1, (int) photoBlob.length());
        }
        return new byte[0];
    }
}
