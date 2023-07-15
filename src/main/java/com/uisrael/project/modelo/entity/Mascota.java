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
	
	private String estado;
	private Date fechaRegistro;
	
	@ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "especieMascota")
    private EspecieMascota especieMascota;

    @ManyToOne
    @JoinColumn(name = "razaMascota")
    private RazaMascota razaMascota;
    
    @OneToMany(mappedBy = "mascota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Diagnostico> listaDiagnosticos;
    
    @ManyToMany
    @JoinTable(
        name = "MascotaSintoma",
        joinColumns = @JoinColumn(name = "mascota_id"),
        inverseJoinColumns = @JoinColumn(name = "sintoma_id")
    )
    private List<Sintoma> sintomaMascota;
}
