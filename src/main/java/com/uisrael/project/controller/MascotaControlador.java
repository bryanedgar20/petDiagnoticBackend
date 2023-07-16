package com.uisrael.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.project.modelo.entity.Usuario;

@RestController
@RequestMapping("/usuario")
public class MascotaControlador {

	@GetMapping("obtenerMascota/{idMascota}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("idMascota") int idMascota) {
		return ResponseEntity.ok(null);
	}
}
