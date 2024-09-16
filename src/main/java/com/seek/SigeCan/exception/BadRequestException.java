package com.seek.SigeCan.exception;

import lombok.Getter;

/**
 * BadRequestException.
 * Excepción lanzada de tipo negocio.
 *
 * @author : VUCE (Ventanilla Única de Comercio Electrónico)
 * @version : 2.0 , 5/06/24
 * @since : 2.0
 */
@Getter
public class BadRequestException extends RuntimeException {
  public BadRequestException(String message) {
    super(message);
  }
}
