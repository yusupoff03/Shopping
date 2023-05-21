package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.card.Card;
import org.example.model.order.Order;
import org.example.model.order.OrderStatus;
import org.example.model.product.Product;
import org.example.model.product.ProductStatus;
import org.example.service.card.CardService;
import org.example.service.history.HistoryService;
import org.example.service.order.OrderService;
import org.example.service.product.ProductService;
import org.example.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
    private final UserService userService;
    private final CardService cardService;
    private final HistoryService historyService;

    @GetMapping(value = "/add-order/{userId}")
    public String addOrderGet(@PathVariable UUID userId, @RequestParam UUID productId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("productId", productId);
        model.addAttribute("amount",productService.getAmount(productId));
        return "addOrder";
    }

    @PostMapping(value = "/add-order/{userId}")
    public String addOrder(@PathVariable UUID userId,
                           @RequestParam Integer amount,
                           @RequestParam UUID productId,
                           Model model) {
        Order order=new Order();
        order.setAmount(amount);
        order.setStatus(OrderStatus.CREATED);
        order.setBalance(amount*productService.getBYId(productId).getBalance());
        orderService.add(order,userId,productId);
        model.addAttribute("user",userService.getById(userId));
        return "UserMenu";
    }
    @GetMapping(value = "/user-orders/{userId}")
    public String userOrdersGet(@PathVariable UUID userId,Model model){
        List<Order> orders=orderService.getUserOrders(userId);
        if(orders==null){
            model.addAttribute("message","You don`t have any orders!!!");
            model.addAttribute("user",userService.getById(userId));
            return "UserMenu";
        }
        model.addAttribute("userId",userId);
        model.addAttribute("orders",orders);
        return "userOrders";
    }
    @GetMapping(value = "/order-delete/{userId}")
    public String delete(@PathVariable UUID userId, @RequestParam UUID orderId,Model model){
        orderService.delete(orderId);
        List<Order> orders=orderService.getUserOrders(userId);
        if(orders==null){
            model.addAttribute("message","You don`t have any orders!!!");
            model.addAttribute("user",userService.getById(userId));
            return "UserMenu";
        }
        model.addAttribute("userId",userId);
        model.addAttribute("orders",orders);
        return "userOrders";
    }
    @GetMapping(value = "/order-buy/{userId}")
    public String buyGet(@PathVariable UUID userId, @RequestParam UUID orderId, Model model){
        model.addAttribute("userId",userId);
        model.addAttribute("order",orderService.getOrder(orderId));
        model.addAttribute("productId",orderService.getByOrderId(orderId));
        return "buy";
    }
    @PostMapping(value = "/order-buy/{userId}")
    public String buy(@PathVariable UUID userId,
                      @RequestParam Integer amount,
                      @RequestParam String number,
                      @RequestParam String password,
                      @RequestParam String receiver_number,
                      @RequestParam UUID orderId,
                      @RequestParam UUID productId,
                      Model model){
        Product product = productService.getBYId(productId);
        Double cost=product.getBalance()*amount;
        Order order = orderService.getOrder(orderId);
        order.setAmount(amount);
        order.setBalance(cost);
        Card card = cardService.getByNumber(number, password, userId);
        if(card==null){
            model.addAttribute("userId",userId);
            model.addAttribute("order",orderService.getOrder(orderId));
            model.addAttribute("productId",orderService.getByOrderId(orderId));
            model.addAttribute("message","Your card number or password is wrong!!!");
            return "buy";
        }
        Card card1=cardService.getBy(receiver_number,product.getUser().getId());
        if(card1==null){
            model.addAttribute("userId",userId);
            model.addAttribute("order",orderService.getOrder(orderId));
            model.addAttribute("productId",orderService.getByOrderId(orderId));
            model.addAttribute("message","Seller card number is wrong!!!");
            return "buy";
        }
        if(card.getBalance()<cost){
            model.addAttribute("userId",userId);
            model.addAttribute("order",orderService.getOrder(orderId));
            model.addAttribute("productId",orderService.getByOrderId(orderId));
            model.addAttribute("message","Your balance is not enough");
            return "buy";
        }
        card.setBalance(card.getBalance()-cost);
        card1.setBalance(card1.getBalance()+cost);
        cardService.update(card);
        cardService.update(card1);
        historyService.add(card,card1,cost);
        if(Objects.equals(product.getAmount(), amount)){
            product.setAmount(0);
            product.setIsActive(ProductStatus.NO_ACTIVE);
            productService.edit(product,productId);
        }else {
            product.setAmount(product.getAmount()-amount);
            productService.edit(product,productId);
        }
        order.setStatus(OrderStatus.IN_PROGRESS);
        orderService.update(order);
        model.addAttribute("user",userService.getById(userId));
        model.addAttribute("message","Product successfully bought");
        return "UserMenu";
    }
}
