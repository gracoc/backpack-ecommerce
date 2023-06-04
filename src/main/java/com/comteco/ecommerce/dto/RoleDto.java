package com.comteco.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RoleDto {

  @NotBlank(message = "{role.name.not-blank}")
  private String description;

  @NotBlank(message = "{Role.description.not-blank}")
  private String name;
}
