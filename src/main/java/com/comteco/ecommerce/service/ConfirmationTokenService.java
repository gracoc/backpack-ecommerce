package com.comteco.ecommerce.service;

import com.comteco.ecommerce.entity.ConfirmationToken;

public interface ConfirmationTokenService {

  ConfirmationToken create(ConfirmationToken confirmationToken);

  ConfirmationToken getByToken(String token);

  void setConfirmedAt(ConfirmationToken confirmationToken);
}
