package io.tmg.lesson09.web.controller.twitt;

import io.tmg.lesson09.facade.twitt.TwittFacadeImpl;
import io.tmg.lesson09.model.twitt.Twitt;
import io.tmg.lesson09.service.twitt.TwittServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/twitt")
public class TwittController {
    @Autowired
    private TwittServiceImpl twittService;
    @Autowired
    private TwittFacadeImpl twittFacade;

    @RequestMapping(value = "/alltwitt", method = RequestMethod.GET)
    public @ResponseBody
    List getAllTwitt() {
        return twittService.getAllTwitt();
    }

    @RequestMapping(value = "/usertwitt", method = RequestMethod.GET)
    public String getUserTwitt(Model model) {
        List<Twitt> showList = twittFacade.showUserTwitt();
        model.addAttribute("twitt", showList);
        return "youTwitt.jsp";
    }


    @RequestMapping(value = "/createtwitt", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("twittFromServer", new Twitt());
        modelAndView.setViewName("addTwitt.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/tt", method = RequestMethod.POST)
    public String chekUser(@ModelAttribute("twittFromServer") Twitt twitt) throws Exception {
        twittService.addTwitt(twitt);
        return "redirect:/twitt/usertwitt";
    }
}
