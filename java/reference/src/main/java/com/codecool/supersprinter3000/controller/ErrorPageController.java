package com.codecool.supersprinter3000.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String infoString = "";
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                infoString += "We'are sorry the page you are looking for does not exists!\n";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                infoString += "We'are sorry, something happened at our end";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                infoString += "We'are sorry, but you don't have access to this resource";
            }
        }
        model.addAttribute("title", "Error | Super Sprinter 3000");
        model.addAttribute("header", infoString);
        return "error_page";
    }
}

