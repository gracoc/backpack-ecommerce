package com.comteco.ecommerce.service;

import com.comteco.ecommerce.dto.AuthenticationRequest;
import com.comteco.ecommerce.dto.AuthenticationResponse;

public interface AuthenticationService {

  AuthenticationResponse authenticate(AuthenticationRequest request);

}
