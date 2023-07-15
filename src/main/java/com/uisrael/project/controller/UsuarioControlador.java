package com.uisrael.project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uisrael.project.modelo.entity.Usuario;
import com.uisrael.project.services.IUsuarioServicio;
import com.uisrael.project.vo.UsuarioVO;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@GetMapping("obtenerUsuario/{idUsuario}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("idUsuario") int idUsuario) {
		return ResponseEntity.ok(this.usuarioServicio.obtenerusuarioPorId(idUsuario));
	}
	
	@GetMapping("obtenerUsuarioLogin/{nickName}/{clave}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("nickName") String nickName,
			@PathVariable("clave") String clave) {
		return ResponseEntity.ok(this.usuarioServicio.obtenerUsuarioPorCredenciales(nickName,clave));
	}
	
	@PostMapping("crearActualizarUsuario")
	public ResponseEntity<Boolean> obtenerUsuarioPorId(@RequestBody String request) throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        UsuarioVO usuarioVO = objectMapper.readValue(request, UsuarioVO.class);
	       
	        Usuario usuario = new Usuario();
	        
	        this.usuarioServicio.crearUsuario(usuario);
	        return ResponseEntity.ok(Boolean.TRUE);
	    } catch (IOException e) {
	        // Manejar la excepción en caso de error de deserialización
	       throw new Exception("Error al convertir:{}",e);
	    }
		
		
		/*
		 * Usuario usuario = (Usuario) request;
		 * this.usuarioServicio.crearUsuario(usuario); return
		 * ResponseEntity.ok(Boolean.TRUE);
		 */
	}
}
