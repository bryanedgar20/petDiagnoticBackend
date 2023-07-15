package com.uisrael.project.modelo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Diagnostico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDiagnostico;
	private Date fechaDiagnostico;
	private String tratamiento;
	private String causasEnfermedad;
	private String informacionAdicional;
	private String duracionTratamiento;
	private String medicamentosRecetados;
	
	
	@ManyToOne
    @JoinColumn(name = "mascota")
    private Mascota mascota;
	
	@ManyToMany
    @JoinTable(
        name = "diagnostico_sintoma",
        joinColumns = @JoinColumn(name = "diagnostico_id"),
        inverseJoinColumns = @JoinColumn(name = "sintoma_id")
    )
    private List<Sintoma> sintomasDiagnostico;
	
	private String estado;
	private Date fechaRegistro;
}
