package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.Dorm;
import dev.pdanh.dormmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DormRepository extends JpaRepository<Dorm, Integer> {
   List<Dorm> findAllByUser(User user);
   Dorm findById(int id);
}