package com.spring.advance.task.springtask.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Getter
    private Long id;
    @Getter
    private String name;
    @Getter
    private String lastName;

    @OneToMany(targetEntity = PhoneNumber.class)
    @Getter
    public List<PhoneNumber> phoneNumbers;

    public User(){}
}
