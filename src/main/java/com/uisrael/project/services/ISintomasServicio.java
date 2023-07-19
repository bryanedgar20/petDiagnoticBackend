package com.uisrael.project.services;

import java.util.List;

import com.uisrael.project.modelo.entity.Sintoma;

public interface ISintomasServicio {

	List<Sintoma> obtenerSintomasPorEspecie(int idEspecie);
}
