package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GRUPO_ESTUDIANTE")
public class GrupoEstudianteEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	 private Long id;

	    @Column(name = "NOMBRE")
	    private String nombre;

	    @Column(name = "ESTADO")
	    private Boolean estado;

	    @Column(name = "LIDER_GRUPO")
	    private String liderGrupo;

	    @Column(name = "LIMITEFIN_PROYECTO")
	    private String limiteFinProyecto;
}
