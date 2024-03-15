package dev.batuhanyetgin.msorder.controller;

import dev.batuhanyetgin.msorder.dto.CreateOrderDto;
import dev.batuhanyetgin.msorder.dto.ResponseOrderDto;
import dev.batuhanyetgin.msorder.exception.BookNotFoundException;
import dev.batuhanyetgin.msorder.service.abstruct.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {
    final private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<ResponseOrderDto> createOrder(@RequestBody List<CreateOrderDto> createOrderDto, @RequestHeader("Authorization") String bearerToken) throws BookNotFoundException {
        return ResponseEntity.ok(orderService.createOrder(createOrderDto, bearerToken));
    }
}
