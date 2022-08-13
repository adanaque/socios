package com.cine.socios.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarSocioRequest {

	private String dni;
	private String nombre;
	private String paterno;
	private String materno;
	private String correo;
	private String telefono;
	private String estado;
	private String tipoMembresia;

}
