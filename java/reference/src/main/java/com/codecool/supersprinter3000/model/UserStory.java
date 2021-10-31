package com.codecool.supersprinter3000.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Story Title must not be empty")
    @Size(min = 5, max = 50, message = "Title should have between 5 and 50 characters")
    private String title;

    @NotNull
    @NotBlank(message = "User Story must not be empty")
    private String story;

    @NotNull
    @NotBlank(message = "Acceptance Criteria must not be empty")
    private String acceptanceCriteria;

    @Range(min = 100, max = 1500, message = "Business Value should be between 100 and 1500 points")
    private int businessValue = 100;

    @DecimalMin("0.5")
    @DecimalMax("40.0")
    private double estimation = 0.5;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public int getBusinessValue() {
        return businessValue;
    }

    public void setBusinessValue(int businessValue) {
        this.businessValue = businessValue;
    }

    public double getEstimation() {
        return estimation;
    }

    public void setEstimation(double estimation) {
        this.estimation = estimation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
