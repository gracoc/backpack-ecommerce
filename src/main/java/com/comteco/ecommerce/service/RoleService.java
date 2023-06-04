package com.comteco.ecommerce.service;

import com.comteco.ecommerce.dto.RoleDto;
import com.comteco.ecommerce.entity.Role;
import java.util.List;

public interface RoleService {

  Role create(RoleDto dto);
  Role getByName(String name);

  List<Role> getAll();

}
