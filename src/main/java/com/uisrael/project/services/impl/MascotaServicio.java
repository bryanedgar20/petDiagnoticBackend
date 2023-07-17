package com.uisrael.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.project.modelo.entity.EspecieMascota;
import com.uisrael.project.modelo.entity.Mascota;
import com.uisrael.project.modelo.repository.IEspecieMascotaRepositorio;
import com.uisrael.project.modelo.repository.IMascotaRepositorio;
import com.uisrael.project.services.IMascotaServicio;

@Service
@Component

public class MascotaServicio implements IMascotaServicio{

	@Autowired
	private IMascotaRepositorio mascotaRepositorio;
	
	@Autowired
	private IEspecieMascotaRepositorio especieMascotaRepositorio;
	
	@Override
	public Mascota obtenerMascotaPorId(int idMascota) {
		// TODO Auto-generated method stub
		return this.mascotaRepositorio.findById(idMascota).orElse(new Mascota());
	}

	@Override
	public void crearActualizarMascota(Mascota mascota) {
		// TODO Auto-generated method stub
		this.mascotaRepositorio.save(mascota);
	}

	@Override
	public EspecieMascota obtenerEspeciePorId(int idEspecieMascota) {
		// TODO Auto-generated method stub
		return this.especieMascotaRepositorio.findById(idEspecieMascota).orElse(new EspecieMascota());
	}

	@Override
	public List<Mascota> obtenerMascotasPorUsuario(int idUsuario) {
		return this.mascotaRepositorio.obtenerMascotasPorUsuario(idUsuario);
	}

}
