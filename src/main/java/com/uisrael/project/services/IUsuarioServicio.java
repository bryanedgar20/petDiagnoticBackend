package com.uisrael.project.services;

import com.uisrael.project.modelo.entity.Usuario;

public interface IUsuarioServicio {

	Usuario obtenerusuarioPorId(int id);
	
	Usuario obtenerUsuarioPorCredenciales(String nickName, String clave);
	
	void crearUsuario(Usuario usuario);
}
