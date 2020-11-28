package com.spring.advance.task.springtask.repository;

import com.spring.advance.task.springtask.domain.PhoneNumber;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository  extends JpaRepository<PhoneNumber, Long>  {
    Optional<PhoneNumber> findByIdAndUserId(Long id, Long userId);

}
