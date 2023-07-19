package com.uisrael.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.project.modelo.entity.Diagnostico;
import com.uisrael.project.modelo.repository.IDiagnosticoRepositorio;
import com.uisrael.project.services.IDiagnosticoServicio;

@Service
@Component
public class DiagnosticoServicio implements IDiagnosticoServicio {

	@Autowired
	private IDiagnosticoRepositorio diagnosticoRepositorio;
	
	@Override
	public void guardarNuevoDiagnostico(Diagnostico nuevo) {
		// TODO Auto-generated method stub
		this.diagnosticoRepositorio.save(nuevo);
	}

	@Override
	public List<Diagnostico> obtenerDiagnosticoPorMascota(int idMascota) {
		// TODO Auto-generated method stub
		return this.diagnosticoRepositorio.obtenerDiagnosticoPorMascota(idMascota);
	}

}
