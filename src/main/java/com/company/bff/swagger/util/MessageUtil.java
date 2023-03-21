package com.company.bff.swagger.util;

import com.company.bff.swagger.domain.enumeration.ExceptionMessage;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

  @Autowired
  MessageSource messageSource;

  public String getMessage(ExceptionMessage message) {
    return messageSource.getMessage(message.getMessageKey(), null, LocaleContextHolder.getLocale());
  }

  public String getMessage(ExceptionMessage message, Locale locale) {
    return messageSource.getMessage(message.getMessageKey(), null, locale);
  }

}
