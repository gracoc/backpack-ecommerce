package com.comteco.ecommerce.mapper;

import com.comteco.ecommerce.dto.RoleDto;
import com.comteco.ecommerce.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

  public Role fromDto(RoleDto dto) {
    Role rol = new Role();
    rol.setDescription(dto.getDescription());
    rol.setName(dto.getName());
    return rol;
  }
}
