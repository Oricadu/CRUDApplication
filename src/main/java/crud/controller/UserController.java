//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package crud.controller;

import crud.model.User;
import crud.service.UserService;
import crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping({"/user"})
    public String user(Principal principal,
                       ModelMap model) {
        model.addAttribute("user",
                userService.getUserByUsername(principal.getName()));
        return "show_user";
    }

}
