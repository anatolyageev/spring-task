package com.spring.advance.task.springtask.repository;

import com.spring.advance.task.springtask.domain.PhoneNumber;
import com.spring.advance.task.springtask.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PhoneNumberRepository  extends JpaRepository<PhoneNumber, Long>  {
    Optional<PhoneNumber> findByNumber(String number);
}
