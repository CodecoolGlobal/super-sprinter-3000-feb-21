package com.codecool.supersprinter3000.controller;

import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class UserStoryController {

    private final UserStoryService userStoryService;

    @Autowired
    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @GetMapping(value = "/")
    public String getIndexPage(Model model){
        model.addAttribute("title", "Welcome | Super Sprinter 3000!");
        model.addAttribute("header","Super Sprinter 3000\n");
        model.addAttribute("allUserStories", userStoryService.getAllUserStories());
        return "index";
    }

    @GetMapping(value = "/story")
    public String getUserStoryPage(Model model, UserStory userStory){
        model.addAttribute("title", "Add User Story | Super Sprinter 3000");
        model.addAttribute("header","Add User Story\n");
        model.addAttribute("userStory", userStory);
        return "add_user_story";
    }

    @PostMapping(value = "/story")
    public String addUserStory(@Valid UserStory userStory, BindingResult result, Model model){
        if (result.hasErrors()) {
            return getUserStoryPage(model, userStory);
        }
        userStoryService.addUserStory(userStory);
        return "redirect:/";
    }

    @GetMapping(value = "/story/{id}")
    public String getUpdateUserStoryPage(Model model, @PathVariable Long id){
        Optional<UserStory> userStory =  userStoryService.getUserStory(id);
        if (userStory.isEmpty()){
            model.addAttribute("title", "Error | Super Sprinter 3000");
            model.addAttribute("header", "We'are sorry the page you are looking for does not exists!\n");
            return "error_page";
        }
        model.addAttribute("title", "Update User Story | Super Sprinter 3000");
        model.addAttribute("header","Update User Story\n");
        model.addAttribute("userStory", userStory.get());
        return "update_user_story";
    }

    @PostMapping(value = "/story/{id}")
    public String updateUserStory(@Valid UserStory newUserStory, BindingResult result,
                                  @PathVariable Long id, Model model){
        if (result.hasErrors()) {
            model.addAttribute("title", "Update User Story | Super Sprinter 3000");
            model.addAttribute("header","Update User Story\n");
            return "update_user_story";
        }
        userStoryService.updateUserStory(newUserStory, id);
        return "redirect:/";
    }

    @ModelAttribute("dropDownAllStatuses")
    public String[] getDropDownAllStatuses() {
        return new String[] {
                "planning", "todo", "in progress", "review", "done"
        };
    }
}
