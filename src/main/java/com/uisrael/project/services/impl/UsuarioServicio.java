package com.uisrael.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.project.modelo.entity.Usuario;
import com.uisrael.project.modelo.repository.IUsuarioRepositorio;
import com.uisrael.project.services.IUsuarioServicio;

@Service
@Component
public class UsuarioServicio implements IUsuarioServicio{

	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;
	
	
	@Override
	public Usuario obtenerusuarioPorId(int id) {
		// TODO Auto-generated method stub
		return this.usuarioRepositorio.findById(id).orElse(new Usuario());
	}

}
