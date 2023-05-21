package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.history.History;
import org.example.model.user.User;
import org.example.service.history.HistoryService;
import org.example.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;
    private final UserService userService;
    @GetMapping(value = "/card-history/{userId}")
    public String UserHistory(
            @PathVariable UUID userId,
            @RequestParam UUID cardId,
            Model model
            ){
        List<History> histories=historyService.getCardHistory(cardId);
        if(histories==null){
            User user=userService.getById(userId);
            model.addAttribute("message","You don`t have a history");
            model.addAttribute("user",user);
            switch (user.getRole()){
                case USER -> {
                    return "UserMenu";
                }
                case SELLER -> {
                    return "menu";
                }
            }
        }
        model.addAttribute("userId",userId);
        model.addAttribute("histories",histories);
        model.addAttribute("cardId",cardId);
        return "histories";
    }
}
