package com.company.bff.swagger.domain.enumeration;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

  /**
   * Generic exception messages.
   */
  INTERNAL_SERVER_ERROR("error.generic.internal-server-error"),
  CLIENT_ERROR("error.generic.client-error"),
  BAD_REQUEST("error.generic.bad-request"),

  /**
   * Balance exception messages.
   */
  BALANCE_NOT_FOUND("error.balance.not-found"),

	/**
	 * User exception messages.
	 */
  USER_NOT_FOUND("error.user.not-found"),
  
  DATE_CONFLICT("error.date.conflict"),
  
  USER_ALREADY_EXISTS("error.user.already-exists");

  private final String messageKey;

  ExceptionMessage(String messageKey) {
    this.messageKey = messageKey;
  }

  @Override
  public String toString() {
    return messageKey;
  }

}
