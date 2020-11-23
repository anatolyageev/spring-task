package com.spring.advance.task.springtask.service;

import com.spring.advance.task.springtask.domain.PhoneNumber;
import com.spring.advance.task.springtask.domain.User;
import com.spring.advance.task.springtask.repository.PhoneNumberRepository;
import com.spring.advance.task.springtask.repository.UserRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PhoneNumberRepository phoneNumberRepository;

    public UserService(UserRepository userRepository, PhoneNumberRepository phoneNumberRepository) {
        this.userRepository = userRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }



    public User getOne(Long id){
        return userRepository.getOne(id);
    }

    public Iterable<User> list() {
        return userRepository.findAll();
    }

    public User save(User user) {
        phoneNumberRepository.saveAll(user.phoneNumbers);
        return userRepository.save(user);
    }

    public void save(List<User> users) {
        users.forEach(this::save);
//        userRepository.saveAll(users);
    }
}
