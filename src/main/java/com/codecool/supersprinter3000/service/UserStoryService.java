package com.codecool.supersprinter3000.service;


import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserStoryService {

    private UserStoryRepository repository;

    @Autowired
    public UserStoryService(UserStoryRepository repository) {
        this.repository = repository;
    }

    public Iterable<UserStory> getAll(){
        return repository.findAll();
    }

    public void saveAll(List<UserStory> userStories) {
//        userStories.stream().forEach(e -> e.setId(null));
        repository.saveAll(userStories);
    }
}
