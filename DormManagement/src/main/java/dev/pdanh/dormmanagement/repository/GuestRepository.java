package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface GuestRepository extends JpaRepository<Guest, Integer> {
}