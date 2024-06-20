package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseRepository extends JpaRepository<Lease, Integer> {
}