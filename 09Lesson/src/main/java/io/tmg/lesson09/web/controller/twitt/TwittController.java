package io.tmg.lesson09.web.controller.twitt;

import io.tmg.lesson09.facade.data.DataTwitt;
import io.tmg.lesson09.facade.twitt.TwittFacade;
import io.tmg.lesson09.model.twitt.Twitt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/twitt")
public class TwittController {
    @Resource
    private TwittFacade twittFacade;

    @RequestMapping(value = "/usertwitt", method = RequestMethod.GET)
    public String getUserTwitt(Model model) {
        List<DataTwitt> showList = twittFacade.showUserTwitt();
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
        twittFacade.addTwitt(twitt);
        return "redirect:/twitt/usertwitt";
    }
}
