package com.uisrael.project.modelo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Sintoma implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSintoma;
	private String nombreSintoma;
	private String descripcion;
	private String gravedad;
	private String duracion;
	private String intensidad;
	private String organoAfecta;
	
	private String estado;
	private Date fechaRegistro;
	
	 @ManyToMany(mappedBy = "sintomasEspecie")
	 private List<EspecieMascota> especiesMascotas;
	
	
	@ManyToMany(mappedBy = "sintomaMascota")
    private List<Mascota> listaMascotas;
	
	
	@ManyToMany(mappedBy = "sintomasDiagnostico")
    private List<Diagnostico> listaDiagnosticos;
}
