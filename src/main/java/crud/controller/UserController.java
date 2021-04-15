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

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping({"/users"})
    public String printUsers(ModelMap model) {
        model.addAttribute("users", this.userService.getUsers());
        return "users";
    }

    @GetMapping({"/{id}/edit_user"})
    public String edit(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", this.userService.get(id));
        return "edit_user";
    }

    @PostMapping({"/users/{id}"})
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id, ModelMap model) {
        model.addAttribute("updatedUser", this.userService.update(id, user));
        return "redirect:/users";
    }

    @GetMapping({"/{id}/remove_user"})
    public String removeUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", this.userService.remove(id));
        model.addAttribute("text", "removed");
        return "show_user";
    }

    @GetMapping({"/{id}"})
    public String show(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute(this.userService.get(id));
        return "show_user";
    }

    @GetMapping({"/add_user"})
    public String add(@ModelAttribute("user") User user) {
        return "add_user";
    }

    @PostMapping({"/users"})
    public String saveUser(@ModelAttribute("user") User user, ModelMap model) {
        this.userService.add(user);
        System.out.println(user.getName());
        return "redirect:/users";
    }

    @GetMapping({"/get_by_email"})
    public String getByEmail(ModelMap model) {
        model.addAttribute(this.userService.getUserByUsername("email@mail.ru"));
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
