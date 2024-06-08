package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.web.dto.UserRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("users/register")
    public String viewRegister(){
        return "register";
    }

    @PostMapping("users/register")
    public String doRegister(UserRegisterDTO data){
        return "index";
    }


}
