package io.tmg.lesson09.web.controller.user;

import io.tmg.lesson09.model.user.User;
import io.tmg.lesson09.service.exception.CustomException;
import io.tmg.lesson09.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/alluser", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer", new User());
        modelAndView.setViewName("authPage.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/chek", method = RequestMethod.POST)
    public String chekUser(@ModelAttribute("userFromServer") User user) {
        if ("admin".equals(user.getUserName()) && "admin".equals(user.getUserPassword())) {
            return "redirect:/twitt/createtwitt";
        } else return "/home/nikol/IdeaProjects/Twitter/src/main/webapp/index.jsp";
    }

    @RequestMapping(value = "/createuser", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userAdd", new User());
        modelAndView.setViewName("userCreate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/cu", method = RequestMethod.POST)
    public String User(@ModelAttribute("userAdd") User user) throws CustomException {
        userService.addUser(user);
        return "redirect:/user/reg";
    }

}
