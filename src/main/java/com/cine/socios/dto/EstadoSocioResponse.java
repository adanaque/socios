package com.cine.socios.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EstadoSocioResponse {
	String dni;
	String estado;
}
