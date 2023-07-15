package com.uisrael.project.vo;

import java.util.Date;

import lombok.Data;

@Data
public class UsuarioVO {

	private int IdUsuario; 
	private String PrimerNombre;
	private String SegundoNombre;
	private String PrimerApellido;
	private String SegundoApellido;
	private Date FechaNacimiento;
	private String Identificacion;
	private String Email;
	private String NumeroTelefono;
	private String CallePrincipal;
	private String CalleSecundaria;
	private String NickName;
	private String Clave;
	private String Estado;
	private Date FechaRegistro;
}
