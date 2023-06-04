package com.comteco.ecommerce.service;

import com.comteco.ecommerce.dto.RoleDto;
import com.comteco.ecommerce.entity.Role;
import com.comteco.ecommerce.exception.EntityNotFoundException;
import com.comteco.ecommerce.mapper.RoleMapper;
import com.comteco.ecommerce.repository.RoleRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;
  private RoleMapper roleMapper;
  @Override
  public Role create(RoleDto dto) {
    Role role = roleMapper.fromDto(dto);
    return role;
  }

  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
  }

  @Override
  public List<Role> getAll() {
    return roleRepository.findAll();
  }
}
