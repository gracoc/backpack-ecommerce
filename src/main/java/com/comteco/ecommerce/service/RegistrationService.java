package com.comteco.ecommerce.service;

import com.comteco.ecommerce.dto.RegistrationRequest;

public interface RegistrationService {

  String register(RegistrationRequest dto);

  String confirm(String token);
}
