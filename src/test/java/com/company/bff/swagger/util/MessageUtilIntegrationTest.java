package com.company.bff.swagger.util;

import static org.assertj.core.api.BDDAssertions.then;

import com.company.bff.swagger.domain.enumeration.ExceptionMessage;
import java.util.Locale;

import com.company.bff.swagger.domain.builder.ExceptionResponseBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ActiveProfiles;

@WebMvcTest({MessageUtil.class, MessageSource.class, ExceptionResponseBuilder.class})
@ActiveProfiles("test")
class MessageUtilIntegrationTest {

  private final String DEFAULT_MESSAGE_FROM_PROPERTIES = "Erro interno";

  @Autowired
  private MessageUtil messageUtil;

  @BeforeEach
  void setup() {
    Locale.setDefault(new Locale("pt", "BR"));
  }

  @Test
  void givenBrazilLocaleParamWhenGetMessageThenReturnDefaultMessage() {
    String message = messageUtil
            .getMessage(ExceptionMessage.INTERNAL_SERVER_ERROR, new Locale("pt", "BR"));

    then(message).isEqualTo(DEFAULT_MESSAGE_FROM_PROPERTIES);
  }

  @Test
  void givenAnyLocaleParamWhenGetMessageThenReturnDefaultMessage() {
    String message = messageUtil.getMessage(ExceptionMessage.INTERNAL_SERVER_ERROR, Locale.US);

    then(message).isEqualTo(DEFAULT_MESSAGE_FROM_PROPERTIES);
  }

  @Test
  void givenDefaultLocaleWhenGetMessageThenReturnDefaultMessage() {
    String message = messageUtil.getMessage(ExceptionMessage.INTERNAL_SERVER_ERROR);

    then(message).isEqualTo(DEFAULT_MESSAGE_FROM_PROPERTIES);
  }

  @Test
  void givenAnyDefaultLocaleWhenGetMessageThenReturnDefaultMessage() {
    Locale.setDefault(Locale.FRANCE);

    String message = messageUtil.getMessage(ExceptionMessage.INTERNAL_SERVER_ERROR);

    then(message).isEqualTo(DEFAULT_MESSAGE_FROM_PROPERTIES);
  }

}

