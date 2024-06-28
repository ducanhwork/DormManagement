package dev.pdanh.dormmanagement.repository;

import dev.pdanh.dormmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findById(int id);
   Optional<User>findUserByUsername(String username);
   Optional<User> findByEmail(String email);

}
