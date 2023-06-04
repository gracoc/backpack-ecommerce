package com.comteco.ecommerce.service;

import com.comteco.ecommerce.entity.Role;
import java.util.List;

public interface RoleService {

  Role getByName(String name);

  List<Role> getAll();
}
