package dev.batuhanyetgin.msorder.controller;

import dev.batuhanyetgin.msorder.dto.CreateOrderDto;
import dev.batuhanyetgin.msorder.dto.ResponseOrderDto;
import dev.batuhanyetgin.msorder.service.abstruct.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {
    final private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<ResponseOrderDto> createOrder(@RequestBody CreateOrderDto createOrderDto, @RequestHeader("Authorization") String bearerToken) {
        orderService.createOrder();
        return ResponseEntity.ok();
    }
}
