package com.codecool.supersprinter3000.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ToString
public class UserStory {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private String acceptanceCriteria;

    private int businessValue;

    private double estimation;

    private String status;

}
