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




    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {

        return "login";
    }
}
