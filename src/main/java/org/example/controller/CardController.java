package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CardDto;
import org.example.model.card.Card;
import org.example.model.user.User;
import org.example.service.card.CardService;
import org.example.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final UserService userService;
    @GetMapping (value = "/add-card/{userId}")
    public String addCardGet(@PathVariable UUID userId, Model model){
        model.addAttribute("userId",userId);
        return "addCard";
    }
    @RequestMapping(value = "/add-card/{userId}",method = RequestMethod.POST)
    public String addCard(@PathVariable UUID userId, @ModelAttribute CardDto cardDto, Model model){
        User user=userService.getById(userId);
        if(cardService.add(cardDto,userId)==1){
           model.addAttribute("user",user);
            switch (user.getRole()){
                case SELLER -> {
                    return "menu";
                }
                case USER -> {
                    return "UserMenu";
                }
            }
        }
        model.addAttribute("message","This card number already used");
        model.addAttribute("user",user);
        switch (user.getRole()) {
            case USER -> {
                return "UserMenu";
            }
            case SELLER -> {
                return "menu";
            }
        }
        return "adminMenu";
    }
    @GetMapping(value = "/my-cards/{userId}")
    public String myCardGet(@PathVariable UUID userId,Model model){
        List<Card> cards=cardService.getUserCards(userId);
        if(cards==null){
            User user=userService.getById(userId);
            model.addAttribute("user",user);
            model.addAttribute("message","You dont have a card!!!");
            switch (user.getRole()){
                case USER -> {
                    return "UserMenu";
                }
                case SELLER -> {
                    return "menu";
                }
            }
        }
        model.addAttribute("cards",cards);
        model.addAttribute("userId",userId);
        return "cards";
    }
    @GetMapping(value = "/cards/delete/{userId}")
    public String delete(@PathVariable UUID userId,
                         @RequestParam UUID cardId,
                         Model model){
        cardService.delete(cardId);
        User user=userService.getById(userId);
         model.addAttribute("user",user );
        switch (user.getRole()){
            case SELLER -> {
                return "menu";
            }
            case USER -> {
                return "UserMenu";
            }
        }
        return "adminMenu";
    }
    @GetMapping(value = "/cards/edit/{userId}")
    public String editGet(@PathVariable UUID userId,
                          @RequestParam UUID cardId,
                          Model model){
        model.addAttribute("userId",userId);
        model.addAttribute("card",cardService.getById(cardId));
        return "cardEdit";
    }
    @PostMapping(value = "/cards/edit/{userId}")
    public String edit(@PathVariable UUID userId,
                       @RequestParam UUID cardId,
                       @ModelAttribute CardDto cardDto,
                       Model model){
          cardService.edit(cardDto,userId,cardId);
          User user=userService.getById(userId);
          model.addAttribute("user",user);
        switch (user.getRole()){
            case SELLER -> {
                return "menu";
            }
            case USER -> {
                return "UserMenu";
            }
        }
        return "adminMenu";
    }
}
