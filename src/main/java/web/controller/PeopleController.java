package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class PeopleController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/user-table")
    public String empTablePage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-table";
    }

    @GetMapping("/user-table/edit")
    public String editPage(@RequestParam(required = true) int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @GetMapping("/user-table/add")
    public String addPage() {
        return "add";
    }

    @PostMapping("/user-table/add")
    public String addUser(@RequestParam String name,
                          @RequestParam String department,
                          @RequestParam double salary) {
        User user = new User(name, department, salary);
        userService.saveUser(user);
        return "redirect:/user-table";
    }

    @PostMapping("/user-table/remove")
    public String removeUser(@RequestParam int id) {
        userService.removeUser(id);
        return "redirect:/user-table";
    }

    @PostMapping("/user-table/edit")
    public String updateUser(@RequestParam int id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String department,
                             @RequestParam(required = false) Double salary) {
        if (name != null) {
            userService.updateUserName(id, name);
        } else if (department != null) {
            userService.updateUserDepartment(id, department);
        } else if (salary != null) {
            userService.updateUserSalary(id, salary);
        }
        return "redirect:/user-table";
    }
}
