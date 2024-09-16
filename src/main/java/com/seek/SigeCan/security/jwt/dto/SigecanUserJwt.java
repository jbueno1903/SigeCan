package com.seek.SigeCan.security.jwt.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * SigecanUserJwt.
 * Description.
 *
 * @author : Julio Bueno
 * @version : 1.0 , 15/09/2024
 * @since : 1.0
 */
@Builder
@Getter
public class SigecanUserJwt {
  private String numeroRuc;
  private String usuarioSol;
  private String idUsuario;
  private String idSesion;
  private String esPrincipal;
  private String tipUsuario;
  private boolean tienePermiso;
  private String idOrganizacion;
  private String idPerfil;
}