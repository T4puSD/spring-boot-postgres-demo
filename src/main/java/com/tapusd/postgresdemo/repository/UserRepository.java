package com.tapusd.postgresdemo.repository;

import com.tapusd.postgresdemo.domain.User;
import com.tapusd.postgresdemo.dto.response.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryExtended {

    @Query(value = "SELECT new com.tapusd.postgresdemo.dto.response.UserDTO(u.id, u.name, u.email, u.age) FROM User u")
    List<UserDTO> getDTOS();
}
