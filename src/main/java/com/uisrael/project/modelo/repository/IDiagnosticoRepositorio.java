package com.uisrael.project.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.project.modelo.entity.Diagnostico;

@Repository
@Component
public interface IDiagnosticoRepositorio extends JpaRepository<Diagnostico, Integer>{

	@Query("Select diag From Diagnostico diag where diag.mascota.idMascota = ?1")
	List<Diagnostico> obtenerDiagnosticoPorMascota(int idMascota);
}
