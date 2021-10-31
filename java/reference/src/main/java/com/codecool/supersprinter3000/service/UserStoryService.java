package com.codecool.supersprinter3000.service;

import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserStoryService {

    private final UserStoryRepository userStoryRepository;

    @Autowired
    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    public Iterable<UserStory> getAllUserStories() {
        return userStoryRepository.findAllByOrderById();
    }

    public Optional<UserStory> getUserStory(long id){
        return userStoryRepository.findById(id);
    }

    public void addUserStory(UserStory userStory){
        userStory.setId(null);
        userStoryRepository.save(userStory);
    }

    public void updateUserStory(UserStory userStory, Long id){
        if (!userStoryRepository.existsById(id)) throw new RuntimeException("UserStory Not Found");
        userStory.setId(id);
        userStoryRepository.save(userStory);
    }
}
