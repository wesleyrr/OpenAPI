package com.company.bff.swagger.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
@Schema(description = "ExceptionResponse")
public class ExceptionResponse {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
  @Schema(description = "Data/Hora")
  private LocalDateTime timestamp;

  @Schema(description = "Mensagem original")
  private String message;

  @Schema(description = "Mensagem traduzida")
  private String translatedMessage;

  @Schema(description = "Código")
  private String code;

  @JsonInclude(JsonInclude.Include.NON_ABSENT)
  @Schema(description = "Lista de erros")
  private List<ObjectErrorResponse> errors;

}
