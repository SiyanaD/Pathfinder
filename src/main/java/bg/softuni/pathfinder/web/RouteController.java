package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class  RouteController {

    private RouteService routeService;


    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model){
        RouteShortInfoDTO randomRoute = routeService.getRandomRoute();

        model.addAttribute("route",randomRoute);

        return "routes";
    }

}
