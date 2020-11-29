package com.spring.advance.task.springtask.service;

import com.spring.advance.task.springtask.domain.Role;
import com.spring.advance.task.springtask.domain.User;
import com.spring.advance.task.springtask.repository.PhoneNumberRepository;
import com.spring.advance.task.springtask.repository.RoleRepository;
import com.spring.advance.task.springtask.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    private final UserRepository userRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PhoneNumberRepository phoneNumberRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)  {
        User user = userRepository.findByUsername(username);

        if (user == null) {

            throw new UsernameNotFoundException("User not found");
        }

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

     phoneNumberRepository.saveAll(user.phoneNumbers);
     user.setRoles(Collections.singleton(new Role(1L,"ROLE_REGISTERED_USER",Collections.singleton(user))));
        return userRepository.save(user);
    }

    public void save(List<User> users) {
        users.forEach(this::save);
    }
    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
