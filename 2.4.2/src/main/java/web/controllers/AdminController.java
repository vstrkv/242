package web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin")
    public ModelAndView adminPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin");
        mav.addObject("userList", userService.listUser());
        return mav;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView addUser(ModelAndView model) {
        model.addObject("user", new User());
        model.addObject("roleList", userService.roleUser());
        model.setViewName("new_user");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
       // user.setRoles(roleList);
        userService.add(user);

        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = "/editUser{id}", method = RequestMethod.GET)
    public ModelAndView editUser(ModelAndView model,@PathVariable("id") Long id) {
        model.addObject("user", userService.getUserById(id));
        model.addObject("roleList", userService.roleUser());
        model.setViewName("edit_user");
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ModelAndView("redirect:/admin");
    }


}
