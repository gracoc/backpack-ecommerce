package com.comteco.ecommerce.controller;

import com.comteco.ecommerce.dto.EmailNotification;
import com.comteco.ecommerce.dto.OrderItemDto;
import com.comteco.ecommerce.repository.OrderRepository;
import com.comteco.ecommerce.service.EmailService;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

  private OrderRepository orderRepository;

  private EmailService emailService;

  @GetMapping("/{orderId}")
  public String getTotalPrice(@PathVariable UUID orderId) {
    double totalPriceSQL = orderRepository.getTotalPriceByOrderId(orderId.toString());
    double totalPriceJPQL = orderRepository.getTotalPrice(orderId);
    return "Total price SQL: " + totalPriceSQL + " Total price JPQL: " + totalPriceJPQL;
  }

  @GetMapping("/items/{orderId}")
  public List<OrderItemDto> getListItems(@PathVariable UUID orderId) {
    List<OrderItemDto> items = orderRepository.getItemsWithTotalPrice(orderId);
    return items;
  }

  @PostMapping
  public void sendEmail() {
    EmailNotification emailNotification = EmailNotification.builder()
        .subject("Test")
        .to("cursosderum@gmail.com")
        .body("Hello world")
        .hasTemplate(false)
        .build();
    emailService.send(emailNotification);
  }
}
