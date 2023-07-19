package com.uisrael.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.project.modelo.entity.EspecieMascota;
import com.uisrael.project.modelo.entity.Mascota;
import com.uisrael.project.modelo.entity.Sintoma;
import com.uisrael.project.modelo.entity.Usuario;
import com.uisrael.project.services.IEspecieServicio;
import com.uisrael.project.services.IMascotaServicio;
import com.uisrael.project.services.ISintomasServicio;

@RestController
@RequestMapping("/mascota")
public class MascotaControlador {

	@Autowired
	private IMascotaServicio mascotaServicio;
	
	@Autowired
	private IEspecieServicio especieServicio;
	
	
	@GetMapping("obtenerEspecie/{idEspecie}")
	public ResponseEntity<List<Sintoma>> obtenerSintomasPorRaza(@PathVariable("idEspecie") int idEspecie) {
		
		EspecieMascota especieMascota = this.especieServicio.obtenerEspeciePorId(idEspecie);
		List<Sintoma> listSintoma = especieMascota.getSintomasEspecie();
		return ResponseEntity.ok(listSintoma);
	}
	
	@GetMapping("obtenerEspeciePorId/{idEspecieMascota}")
	public ResponseEntity<EspecieMascota> obtenerEspeciePorId(@PathVariable("idEspecieMascota") int idEspecieMascota) {
		return ResponseEntity.ok(this.mascotaServicio.obtenerEspeciePorId(idEspecieMascota));
	}
	
	@GetMapping("obtenerMascota/{idMascota}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("idMascota") int idMascota) {
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("obtenerMascotaPorIdusuario/{idUsuario}")
	public ResponseEntity<List<Mascota>> obtenerMascotaPorIdusuario(@PathVariable("idUsuario") int idUsuario) {
		return ResponseEntity.ok(this.mascotaServicio.obtenerMascotasPorUsuario(idUsuario));
	}
	
	@PostMapping("crearActualizarMascota")
	public ResponseEntity<Boolean> crearActualizarMascota(@RequestBody Mascota request) {
		System.out.println("Mascota: "+request);
		this.mascotaServicio.crearActualizarMascota(request);
        return ResponseEntity.ok(Boolean.TRUE);
		
	}
}
