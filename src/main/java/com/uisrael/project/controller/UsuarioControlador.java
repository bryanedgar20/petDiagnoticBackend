package com.uisrael.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.project.modelo.entity.Usuario;
import com.uisrael.project.services.IUsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@GetMapping("obtenerUsuario/{idUsuario}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("idUsuario") int idUsuario) {
		return ResponseEntity.ok(this.usuarioServicio.obtenerusuarioPorId(idUsuario));
	}
}
