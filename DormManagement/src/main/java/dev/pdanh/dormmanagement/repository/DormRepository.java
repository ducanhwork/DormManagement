package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DormRepository extends JpaRepository<Dorm, Integer> {
    
}