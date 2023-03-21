package com.company.bff.swagger.domain.exception.handler;

import static java.util.Collections.singletonList;

import com.company.bff.swagger.domain.enumeration.ExceptionMessage;
import com.company.bff.swagger.domain.builder.ExceptionResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.bff.swagger.domain.exception.BusinessException;
import com.company.bff.swagger.domain.response.ExceptionResponse;
import com.company.bff.swagger.domain.response.ObjectErrorResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionResponseBuilder responseBuilder;

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ExceptionResponse> handleFeignException(FeignException exception) {

        ExceptionResponse exceptionResponse =
                responseBuilder.getExceptionResponse(ExceptionMessage.CLIENT_ERROR);

        log.error(exceptionResponse.getMessage(), exception);

        return ResponseEntity.status(exception.status()).body(exceptionResponse);
    }

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<ExceptionResponse> handleBusinessError(BusinessException exception) {
        return ResponseEntity.status(exception.getStatus())
                .body(responseBuilder.getExceptionResponse(exception.getReason()));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleInternalServerError(Exception exception) {

        ExceptionResponse exceptionResponse =
                responseBuilder.getExceptionResponse(ExceptionMessage.INTERNAL_SERVER_ERROR);

        log.error("Unexpected exception occurred: " + exceptionResponse.getMessage(), exception);

        return exceptionResponse;
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ExceptionResponse handleMissingRequestHeader(MissingRequestHeaderException exception) {

        ExceptionResponse exceptionResponse =
                responseBuilder.getExceptionResponse(ExceptionMessage.BAD_REQUEST);

        exceptionResponse.setErrors(singletonList(new ObjectErrorResponse("Header não informado.", exception.getHeaderName())));

        log.error("Header não informado: " + exception.getHeaderName(), exception);

        return exceptionResponse;
    }

}
