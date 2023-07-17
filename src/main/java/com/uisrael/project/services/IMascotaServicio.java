package com.uisrael.project.services;

import java.util.List;

import com.uisrael.project.modelo.entity.EspecieMascota;
import com.uisrael.project.modelo.entity.Mascota;

public interface IMascotaServicio {

	EspecieMascota obtenerEspeciePorId(int idEspecieMascota);
	
	Mascota obtenerMascotaPorId(int idMascota);
	
	void crearActualizarMascota(Mascota mascota);
	
	List<Mascota> obtenerMascotasPorUsuario(int idUsuario);
}
