package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}