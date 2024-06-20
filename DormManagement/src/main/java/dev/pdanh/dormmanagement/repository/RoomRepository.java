package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}