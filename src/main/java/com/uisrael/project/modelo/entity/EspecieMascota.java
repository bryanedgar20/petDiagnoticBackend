package com.uisrael.project.modelo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class EspecieMascota implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspecieMascota;
	private String nombre;
	private String descripcion;
	
	private String estado;
	private Date fechaRegistro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "especieMascota", fetch = FetchType.LAZY)
    private List<RazaMascota> listaRazas;
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(
        name = "EspecieMascotaSintoma",
        joinColumns = @JoinColumn(name = "especie_mascota_id"),
        inverseJoinColumns = @JoinColumn(name = "sintoma_id")
    )
    private List<Sintoma> sintomasEspecie;
	
}
