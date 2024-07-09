package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.Dorm;
import dev.pdanh.dormmanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByDorm(Dorm dorm);
    List<Room> findAllByDormAndStatus(Dorm dorm,Boolean status);
    Room findRoomById(int id);
}
