package com.spring.advance.task.springtask.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    @Getter
    private String name;
    @Getter
    private String lastName;

    @OneToMany(targetEntity = PhoneNumber.class)
    @Getter
    public List<PhoneNumber> phoneNumbers;

    public User() {
    }
}
