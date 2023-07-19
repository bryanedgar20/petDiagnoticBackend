package com.uisrael.project.services;

import java.util.List;

import com.uisrael.project.modelo.entity.Diagnostico;

public interface IDiagnosticoServicio {

	void guardarNuevoDiagnostico(Diagnostico nuevo);
	
	List<Diagnostico> obtenerDiagnosticoPorMascota(int idMascota);
}
