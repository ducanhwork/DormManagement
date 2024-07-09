package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.Dorm;
import dev.pdanh.dormmanagement.model.Lease;
import dev.pdanh.dormmanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LeaseRepository extends JpaRepository<Lease, Integer> {
    List<Lease> findAllByRoom(Room room);
    @Query("select l.id,l.endDate,l.startDate,l.guest,l.room from Lease l join Room r on l.room=r where r in " +
            "(select Room.id,Room.roomNum,Room.status,Room.dorm from Room where Room.dorm = :dorm )")
    List<Lease> findAllByDorm(@Param("dorm") Dorm dorm);
}