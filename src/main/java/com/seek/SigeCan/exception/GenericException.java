package com.seek.SigeCan.exception;

import lombok.Data;

/**
 * GenericException.
 * Excepción de tipo no controlado.
 *
 * @author : VUCE (Ventanilla Única de Comercio Electrónico)
 * @version : 2.0 , 5/06/24
 * @since : 2.0
 */
@Data
public class GenericException extends RuntimeException {
  public GenericException(String message) {
    super(message);
  }
}
