package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.service.product.ProductService;
import org.example.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final ProductService productService;

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String signUpGet() {
        return "signUp";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute User user,
                         Model model) {
        User user1 = userService.add(user);
        if (user1==null){
            model.addAttribute("message", """
This phone number already exist!!
Please sign in or try again with another phone number!!!""");
            return "signUp";
        }
        model.addAttribute(user1);
        if(user1.getRole().equals(UserRole.USER)){
            return "UserMenu";
        } else if (user1.getRole().equals(UserRole.SELLER)) {
            return "menu";
        }
        return "adminMenu";

    }
    @RequestMapping(value = "/sign-in",method = RequestMethod.GET)
    public String signInGet(){
        return "signIn";
    }
    @RequestMapping(value = "/sign-in",method = RequestMethod.POST)
    public String signIn(@RequestParam String phonenumber,
                         @RequestParam String password,
                         Model model){
        User user=userService.sign_In(phonenumber,password);
        if (user==null) {
           model.addAttribute("message","Wrong phone number or password!!Please sign-up or try again another password or phone number");
           return "signIn";
        }
        model.addAttribute(user);
        switch (user.getRole()){
            case ADMIN -> {
                return "adminMenu";
            }
            case SELLER -> {
                return "menu";
            }
            default -> {
                model.addAttribute("products",productService.getALL());
                return "UserMenu";
            }
        }
    }
    @RequestMapping(value = "/back/{id}")
    public String back(@PathVariable UUID id,Model model){
        User user=userService.getById(id);
        model.addAttribute(user);
        switch (user.getRole()){
            case USER -> {
                return "UserMenu";
            }case SELLER -> {
                return "menu";
            }
        }
        return "adminMenu";
    }
}
