package crud.controller;

import crud.model.Role;
import crud.model.User;
import crud.service.RoleService;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public AdminController() {
    }

    @GetMapping({"/"})
    public String printUsers(ModelMap model) {
        model.addAttribute("users", this.userService.getUsers());
        return "users";
    }

    @GetMapping({"/{id}/edit_user"})
    public String edit(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", this.userService.get(id));
        model.addAttribute("userRoles", roleService.getListRoles());
        model.addAttribute("allRoles", roleService.getListRoles());
        return "edit_user";
    }

    @PostMapping({"/users/{id}"})
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id, ModelMap model) {
        model.addAttribute("updatedUser", this.userService.update(id, user));
        return "redirect:/admin/";
    }

    @GetMapping({"/{id}/remove_user"})
    public String removeUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", this.userService.remove(id));
        model.addAttribute("text", "removed");
        return "show_user";
    }


    @GetMapping({"/add_user"})
    public String add(@ModelAttribute("user") User user,
                      ModelMap model) {
        model.addAttribute("allRoles", roleService.getListRoles());
        return "add_user";
    }



    @PostMapping({"/users"})
    public String saveUser(@ModelAttribute("user") User user,
                           @RequestParam("roles") List<Role> roles,
                           ModelMap model) {
        System.out.println(user);
        System.out.println(roles);
        this.userService.add(user);
        System.out.println(user.getName());
        return "redirect:/admin/";
    }

    @GetMapping({"/{id}"})
    public String show(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute(this.userService.get(id));
        return "show_user";
    }


    @GetMapping({"/get_by_email"})
    public String getByEmail(ModelMap model) {
        model.addAttribute(this.userService.getUserByUsername("email@mail.ru"));
        return "show_user";
    }
}
