package com.comteco.ecommerce.service;

import com.comteco.ecommerce.dto.EmailNotification;

public interface EmailService {

  String send(EmailNotification email);
}
