package com.uisrael.project.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.project.modelo.entity.Mascota;

@Repository
@Component
public interface IMascotaRepositorio extends JpaRepository<Mascota, Integer>{

	@Query("Select mascota From Mascota mascota where mascota.usuario.idUsuario = ?1")
	List<Mascota> obtenerMascotasPorUsuario(int idUsuario);
	
}
