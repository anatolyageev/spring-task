package com.spring.advance.task.springtask.repository;

import com.spring.advance.task.springtask.domain.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository  extends JpaRepository<PhoneNumber, Long>  {

}
