package com.comteco.ecommerce.security.jwt;

import com.comteco.ecommerce.entity.User;

public interface JwtService {

  String createToken(User user);

  User decodeToken(String token);

}
