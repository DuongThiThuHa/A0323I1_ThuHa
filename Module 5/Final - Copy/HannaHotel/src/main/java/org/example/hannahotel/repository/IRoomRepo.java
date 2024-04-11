package org.example.hannahotel.repository;

import org.example.hannahotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoomRepo extends JpaRepository< Room, Long > {
    @Query("select distinct r.roomType from Room r")
    List<String> findDistinctRoomTypes();

}
