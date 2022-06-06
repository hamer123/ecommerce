package com.pw.ecommerce.order.presentation.order.api;

import com.pw.ecommerce.order.domain.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
class OrderController {

    private final OrderService orderService;

    @PostMapping
    String createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        //todo
        return null;
    }
}
