package com.uisrael.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.project.modelo.entity.Sintoma;
import com.uisrael.project.modelo.repository.ISintomasRepositorio;
import com.uisrael.project.services.ISintomasServicio;

@Service
@Component
public class SintomasServicio implements ISintomasServicio{

	@Autowired
	private ISintomasRepositorio sintomasRepositorio;
	
	@Override
	public List<Sintoma> obtenerSintomasPorEspecie(int idEspecie) {
		// TODO Auto-generated method stub
		return null;
	}

}
