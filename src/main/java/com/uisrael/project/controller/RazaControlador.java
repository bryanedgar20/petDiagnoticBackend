package com.uisrael.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.project.modelo.entity.RazaMascota;
import com.uisrael.project.services.IRazaMascotaServicio;

@RestController
@RequestMapping("/raza")
public class RazaControlador {

	@Autowired
	private IRazaMascotaServicio razaMascotaServicio;
	
	
	@GetMapping("obtenerRazaPorEspecie/{idEspecieMascota}")
	public ResponseEntity<List<RazaMascota>> obtenerRazaPorEspecie(@PathVariable("idEspecieMascota") int idEspecieMascota) {
		List<RazaMascota> listRaza = this.razaMascotaServicio.obtenerRazasPorEspecie(idEspecieMascota);
		return ResponseEntity.ok(listRaza);
	}
}
