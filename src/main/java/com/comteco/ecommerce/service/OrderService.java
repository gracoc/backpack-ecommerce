package com.comteco.ecommerce.service;


import com.comteco.ecommerce.dto.OrderDto;
import java.util.UUID;

public interface OrderService {

  String create(OrderDto order);

  OrderDto getById(UUID id);
}
