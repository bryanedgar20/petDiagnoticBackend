package com.uisrael.project.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.project.modelo.entity.RazaMascota;

@Repository
@Component
public interface IRazaMascotaRepositorio extends JpaRepository<RazaMascota, Integer> {

	@Query("Select raza from RazaMascota raza where raza.especieMascota.idEspecieMascota = ?1")
	List<RazaMascota> obtenerRazaPorEspecie(int idEspecieMascota);
}
