package com.cine.socios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "socios")
public class Socio {

	@Id
	private String dni;
	private String nombre;
	private String paterno;
	private String materno;
	private String correo;
	private String telefono;
	private String estado;
	private String tipoMembresia;

}
