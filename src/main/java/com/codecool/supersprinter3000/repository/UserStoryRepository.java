package com.codecool.supersprinter3000.repository;

import com.codecool.supersprinter3000.model.UserStory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoryRepository extends CrudRepository<UserStory, Long> {

    List<UserStory> findAllByEstimation(double estimation);
}
