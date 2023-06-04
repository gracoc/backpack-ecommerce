package com.comteco.ecommerce.controller;

import com.comteco.ecommerce.dto.RoleDto;
import com.comteco.ecommerce.entity.Role;
import com.comteco.ecommerce.service.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

  private RoleService roleService;

  @PostMapping
  public ResponseEntity<Role> create(@Valid @RequestBody RoleDto dto){
    Role roleSaved = roleService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(roleSaved);
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<Role> getByName(@PathVariable String name) {
    Role roleFound = roleService.getByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(roleFound);
  }

  @GetMapping
  public ResponseEntity<List<Role>> getAll() {
    List<Role> roles = roleService.getAll();
    return ResponseEntity.ok(roles);
  }

}
