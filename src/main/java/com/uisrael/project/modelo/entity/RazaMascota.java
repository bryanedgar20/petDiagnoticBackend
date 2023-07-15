package com.uisrael.project.modelo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class RazaMascota implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTRazaMascota;
	private String nombre;
	private String descripcion;
	
	private String estado;
	private Date fechaRegistro;
	
	@ManyToOne
    @JoinColumn(name = "especieMascota")
    private EspecieMascota especieMascota;
}
