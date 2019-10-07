package com.nemchinovrp.serverproductmanagement.repository;

import com.nemchinovrp.serverproductmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //findBy + fieldName
    Optional<User> findByUsername(String username);
}
