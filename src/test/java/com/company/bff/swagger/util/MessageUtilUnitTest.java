package com.company.bff.swagger.util;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

import com.company.bff.swagger.domain.enumeration.ExceptionMessage;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

@ExtendWith(MockitoExtension.class)
class MessageUtilUnitTest {

  private String message;

  @Mock
  private MessageSource messageSource;

  @InjectMocks
  private MessageUtil messageUtil;

  @BeforeEach
  void setup() {
    message = "Test message";
  }

  @Test
  void givenValidExceptionMessageAndLocaleParamWhenGetMessageThenReturnMessage() {
    given(messageSource.getMessage("error.generic.internal-server-error", null, Locale.US))
            .willReturn(message);

    String message = messageUtil.getMessage(ExceptionMessage.INTERNAL_SERVER_ERROR, Locale.US);

    then(message).isEqualTo(message);
  }

  @Test
  void givenValidExceptionMessageWhenGetMessageThenReturnMessage() {
    Locale.setDefault(Locale.US);

    given(messageSource.getMessage("error.generic.internal-server-error", null, Locale.US))
            .willReturn(message);

    String message = messageUtil.getMessage(ExceptionMessage.INTERNAL_SERVER_ERROR);

    then(message).isEqualTo(message);
  }

}
