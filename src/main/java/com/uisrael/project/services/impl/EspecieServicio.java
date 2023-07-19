package com.uisrael.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.project.modelo.entity.EspecieMascota;
import com.uisrael.project.modelo.repository.IEspecieMascotaRepositorio;
import com.uisrael.project.services.IEspecieServicio;

@Service
@Component
public class EspecieServicio implements IEspecieServicio{

	@Autowired
	private IEspecieMascotaRepositorio especieMascotaRepositorio;
	
	
	@Override
	public EspecieMascota obtenerEspeciePorId(int idEspecie) {
		return especieMascotaRepositorio.findById(idEspecie).orElse(new EspecieMascota());
	}

}
