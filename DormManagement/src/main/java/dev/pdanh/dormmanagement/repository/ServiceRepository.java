package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}