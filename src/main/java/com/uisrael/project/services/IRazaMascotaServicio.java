package com.uisrael.project.services;

import java.util.List;

import com.uisrael.project.modelo.entity.RazaMascota;

public interface IRazaMascotaServicio {

	List<RazaMascota> obtenerRazasPorEspecie(int idEspecieMascota);
}
