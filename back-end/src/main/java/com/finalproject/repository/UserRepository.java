package com.finalproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finalproject.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  @Query("UPDATE User u SET u.failedAttempt=:failedAttempt WHERE u.email = :email")
  @Modifying
  public void updateFailedAttempts(@Param("failedAttempt") int failedAttempt, @Param("email") String email);

  public User findByEmail(String email);

}
