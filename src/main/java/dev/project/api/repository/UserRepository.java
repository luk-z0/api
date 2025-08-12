package dev.project.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.project.api.dto.UserDTO;
import dev.project.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Modifying
    @Query("UPDATE User u SET u.username = :#{user.username}  WHERE u.id = :userId")
    void update(@Param("userId") Long id, @Param("user") UserDTO user);
}
