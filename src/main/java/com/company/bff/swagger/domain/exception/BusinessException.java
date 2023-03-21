package com.company.bff.swagger.domain.exception;

import com.company.bff.swagger.domain.enumeration.ExceptionMessage;
import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * Class responsible for service layer exception mapping. Deals with HTTP response status codes and
 * business messages.
 */
@Getter
public class BusinessException extends DefaultException {

  private static final long serialVersionUID = -7602605227406033265L;

  /**
   * @param status the HTTP response status code
   * @param reason the exception message
   * @param cause  the error cause
   */
  public BusinessException(HttpStatus status, ExceptionMessage reason, Throwable cause) {
    super(status, reason, cause);
  }

  /**
   * @param status the HTTP response status code (uses {@link HttpStatus#valueOf(int)})
   * @param reason the exception message
   * @param cause  the error cause
   */
  public BusinessException(Integer status, ExceptionMessage reason, Throwable cause) {
    super(HttpStatus.valueOf(status), reason, cause);
  }

  /**
   * @param status the HTTP response status code
   * @param reason the exception message
   */
  public BusinessException(HttpStatus status, ExceptionMessage reason) {
    super(status, reason);
  }

  /**
   * @param status the HTTP response status code (uses {@link HttpStatus#valueOf(int)})
   * @param reason the exception message
   */
  public BusinessException(Integer status, ExceptionMessage reason) {
    super(HttpStatus.valueOf(status), reason);
  }

  /**
   * @param reason the exception message
   */
  public BusinessException(ExceptionMessage reason) {
    super(reason);
  }

}
