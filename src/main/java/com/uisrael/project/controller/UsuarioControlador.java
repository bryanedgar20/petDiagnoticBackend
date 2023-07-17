package com.uisrael.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
		Usuario user =  this.usuarioServicio.obtenerUsuarioPorCredenciales(nickName,clave);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("crearActualizarUsuario")
	public ResponseEntity<Boolean> obtenerUsuarioPorId(@RequestBody Usuario request) {
		
		this.usuarioServicio.crearUsuario(request);
        return ResponseEntity.ok(Boolean.TRUE);
		
	}
}
