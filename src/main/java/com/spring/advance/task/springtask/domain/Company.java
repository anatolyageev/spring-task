package com.spring.advance.task.springtask.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Company {
    private String name;

    public Company() {
    }
}
