package com.flwr.admin.user.repository;

import com.flwr.admin.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
  Optional<User> findByEmail(String email);

  boolean existsByEmail(String email);

  // @Modifying
  // @Query("UPDATE User u SET u.email = :email WHERE u.id = :id") // User는 클래스 객체명
  // int updateUserAgeByNameFromJpql(@Param("email") String email, @Param("id") int id);
}