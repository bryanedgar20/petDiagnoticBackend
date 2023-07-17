package com.uisrael.project.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MascotaVO {

	private int idMascota;
	private String nombre;
	private Date fechaNacimiento;
	private String contextura;
	private String descripcion;
	private String colorPelaje;
	private Double peso;
	
	private String estado;
	private Date fechaRegistro;
}
