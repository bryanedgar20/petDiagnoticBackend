package com.uisrael.project.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.project.modelo.entity.Usuario;

@Repository
@Component
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	@Query("Select usu From Usuario usu where usu.nickName = ?1 and usu.clave = ?2")
	Usuario obtenerUsuarioPorCredenciales(String nickName, String clave);
}
