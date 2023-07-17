package com.uisrael.project.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uisrael.project.modelo.entity.Mascota;

import lombok.Data;

@Data
public class UsuarioVO {

	private int idUsuario; 
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private String identificacion;
	private String email;
	private String numeroTelefono;
	private String callePrincipal;
	private String calleSecundaria;
	private String nickName;
	private String clave;
	private String estado;
	private Date fechaRegistro;
	
	private List<Mascota> listaMascotas = new ArrayList<>();
}
