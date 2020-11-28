package com.spring.advance.task.springtask.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    @JsonBackReference(value = "user_phone")
    private User user;

    @Embedded
    private Company company;

    public PhoneNumber() {
    }


}
