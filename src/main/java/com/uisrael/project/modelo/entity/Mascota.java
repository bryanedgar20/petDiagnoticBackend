package com.uisrael.project.modelo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Mascota implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMascota;
	private String nombre;
	private Date fechaNacimiento;
	private String contextura;
	private String descripcion;
	private String colorPelaje;
	private Double peso;
	
	private String estado;
	private Date fechaRegistro;
	
	@JsonProperty
	@ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
	
	@JsonProperty
	@ManyToOne
    @JoinColumn(name = "especieMascota")
    private EspecieMascota especieMascota;

	@JsonProperty
    @ManyToOne
    @JoinColumn(name = "razaMascota")
    private RazaMascota razaMascota;
    
	
	@JsonIgnore
    @OneToMany(mappedBy = "mascota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Diagnostico> listaDiagnosticos;
    
	
	@JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "MascotaSintoma",
        joinColumns = @JoinColumn(name = "mascota_id"),
        inverseJoinColumns = @JoinColumn(name = "sintoma_id")
    )
    private List<Sintoma> sintomaMascota;
}
