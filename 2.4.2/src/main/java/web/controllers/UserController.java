package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public ModelAndView userPage() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        ModelAndView model = new ModelAndView();
        model.addObject("user", userService.getUserByName(username));
        model.setViewName("user");
        return model;
    }
}
