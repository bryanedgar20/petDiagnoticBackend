package com.uisrael.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.project.modelo.entity.RazaMascota;
import com.uisrael.project.modelo.repository.IRazaMascotaRepositorio;
import com.uisrael.project.services.IRazaMascotaServicio;

@Service
@Component
public class RazaMascotaServicio implements IRazaMascotaServicio {

	@Autowired
	private IRazaMascotaRepositorio razaMascotaRepositorio;
	
	@Override
	public List<RazaMascota> obtenerRazasPorEspecie(int idEspecieMascota) {
		// TODO Auto-generated method stub
		return this.razaMascotaRepositorio.obtenerRazaPorEspecie(idEspecieMascota);
	}

}
