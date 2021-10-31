package com.codecool.supersprinter3000.controller;

import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.repository.UserStoryRepository;
import com.codecool.supersprinter3000.service.UserStoryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserStoryController {


    private final UserStoryService service;

    @Autowired
    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    // @PathVariable, @RequestBody

    @GetMapping
    public String getIndexPage(Model model){
        model.addAttribute("title", "Welcome | Super Sprinter 3000!");
        model.addAttribute("allUserStories", service.getAll());
        return "index";
    }

    @GetMapping("/populate")
    @ResponseBody
    public void populate(){
        UserStory userStory = new UserStory();
        userStory.setEstimation(10);
        userStory.setStatus("tytul 1");

        UserStory userStory2 = new UserStory();
        userStory2.setEstimation(5);
        userStory2.setStatus("tytul 2");

        service.saveAll(Arrays.asList(userStory, userStory2));
    }
}
