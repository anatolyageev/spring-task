package com.spring.advance.task.springtask.service;

import com.spring.advance.task.springtask.domain.PhoneNumber;
import com.spring.advance.task.springtask.domain.User;
import com.spring.advance.task.springtask.repository.PhoneNumberRepository;
import com.spring.advance.task.springtask.repository.RoleRepository;
import com.spring.advance.task.springtask.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PhoneNumberRepository phoneNumberRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.roleRepository = roleRepository;
    }

    public User loadUserByUsername(String username)  {
        User user = userRepository.findByUsername(username);

//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }

        return user;
    }

    public User getOne(Long id) {
        Optional<User> userFromDb = userRepository.findById(id);
        return userFromDb.orElse(new User());
    }

    public Iterable<User> list() {
        return userRepository.findAll();
    }

    public User save(User user) {
//        user.phoneNumbers.forEach(phoneNumberRepository::save);
 //       phoneNumberRepository.saveAll(user.phoneNumbers);
//        PhoneNumber phoneNumber = new PhoneNumber();
     phoneNumberRepository.saveAll(user.phoneNumbers);
        return userRepository.save(user);
    }

    public void save(List<User> users) {
        users.forEach(this::save);
//        userRepository.saveAll(users);
    }

}
