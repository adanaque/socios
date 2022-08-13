package com.cine.socios.controller;

import com.cine.socios.dto.EstadoSocioResponse;
import com.cine.socios.dto.RegistrarSocioRequest;
import com.cine.socios.model.Socio;
import com.cine.socios.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class SocioController {

	@Autowired
	private SocioRepository socioRepository;

	@GetMapping("/socios/{dni}")
	public ResponseEntity<Socio> obtenerSocio(@PathVariable String dni)	{
		return ResponseEntity.ok(socioRepository.findById(dni).orElseThrow());
	}

	@GetMapping("/socios/estado/{dni}")
	public ResponseEntity<EstadoSocioResponse> obtenerEstadoSocio(@PathVariable String dni)	{
		var socioResponse = socioRepository.findById(dni).orElseThrow();

		return ResponseEntity.ok(EstadoSocioResponse.builder()
				.dni(socioResponse.getDni())
						.estado(socioResponse.getEstado())
				.build());
	}

	@PostMapping("/socios")
	public ResponseEntity<Void> registrarSocio(@RequestBody RegistrarSocioRequest registrarSocioRequest)	{
		socioRepository.insert(Socio.builder()
				.dni(registrarSocioRequest.getDni())
						.nombre(registrarSocioRequest.getNombre())
						.paterno(registrarSocioRequest.getPaterno())
						.materno(registrarSocioRequest.getMaterno())
						.telefono(registrarSocioRequest.getTelefono())
						.correo(registrarSocioRequest.getCorreo())
						.estado(registrarSocioRequest.getEstado())
						.tipoMembresia(registrarSocioRequest.getTipoMembresia())
				.build());
		return ResponseEntity.created(UriComponentsBuilder.fromPath("/socios/{dni}").
				buildAndExpand(registrarSocioRequest.getDni()).toUri()).build();
	}

	@PatchMapping("/socios")
	public ResponseEntity<Void> modificarSocio(@RequestBody RegistrarSocioRequest registrarSocioRequest)	{
		var socioResponse = socioRepository.findById(registrarSocioRequest.getDni()).orElseThrow();
		socioResponse.setNombre(registrarSocioRequest.getNombre());
		socioResponse.setPaterno(registrarSocioRequest.getPaterno());
		socioResponse.setMaterno(registrarSocioRequest.getMaterno());
		socioResponse.setTelefono(registrarSocioRequest.getTelefono());
		socioResponse.setCorreo(registrarSocioRequest.getCorreo());
		socioResponse.setEstado(registrarSocioRequest.getEstado());
		socioResponse.setTipoMembresia(registrarSocioRequest.getTipoMembresia());
		socioRepository.save(socioResponse);
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/socios/estado/{dni}/{estado}")
	public ResponseEntity<Void> modificarEstadoSocio(
			@PathVariable String dni, @PathVariable String estado)	{
		var socioResponse = socioRepository.findById(dni).orElseThrow();
		socioResponse.setEstado(estado);
		socioRepository.save(socioResponse);
		return ResponseEntity.ok().build();
	}

}