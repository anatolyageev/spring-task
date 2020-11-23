package com.spring.advance.task.springtask.repository;

import com.spring.advance.task.springtask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
