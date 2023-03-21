package com.company.bff.swagger.domain.builder;

import com.company.bff.swagger.domain.enumeration.ExceptionMessage;
import com.company.bff.swagger.domain.response.ExceptionResponse;
import com.company.bff.swagger.util.MessageUtil;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExceptionResponseBuilder {

  @Autowired
  private MessageUtil messageUtil;

  public ExceptionResponse getExceptionResponse(ExceptionMessage exceptionMessage) {
    return ExceptionResponse.builder()
            .timestamp(LocalDateTime.now())
            .message(messageUtil.getMessage(exceptionMessage))
            .build();
  }

}
