package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView index(){
        double sofiaTemp = new Random().nextDouble();

        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("index");
        mnv.addObject("sofiaTemperature",sofiaTemp);

        return mnv;
    }
}
