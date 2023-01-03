package ru.rotar.SpringBootBD.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rotar.SpringBootBD.model.User;
import ru.rotar.SpringBootBD.service.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/index")
    @PreAuthorize("hasAnyRole ('USER', 'ADMIN')")
    public String index(Model model) {
        model.addAttribute("people", userService.findAll());
        return "user/index";
    }

    @GetMapping("/address")
    @PreAuthorize ("hasAnyRole ('USER', 'ADMIN')")
    public String getAddress(Model model, @RequestParam int id) {
        User address = userService.findOne(id);
        model.addAttribute("address", address);
        return "user/address";
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole ('ADMIN')")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user/index";
    }

    @GetMapping("/{id}/edit")
    @PreAuthorize ("hasRole ('ADMIN')")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", userService.findOne(id));
        return "user/new";
    }

    @GetMapping(value = "/new")
    @PreAuthorize ("hasRole ('ADMIN')")
    public String userCreate(Model model, User user) {
        model.addAttribute("person", user);
        return "user/new";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("person")  User user){
        userService.saveUser(user);
        return "redirect:/user/index";
    }
}