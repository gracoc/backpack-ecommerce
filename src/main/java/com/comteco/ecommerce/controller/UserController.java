package com.comteco.ecommerce.controller;

import com.comteco.ecommerce.dto.UserDto;
import com.comteco.ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getById(@PathVariable UUID id) {
    ;
    return ResponseEntity.ok(userService.getById(id));
  }
}
