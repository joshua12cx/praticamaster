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
@Table(name = "ESTUDIANTE")
public class EstudianteEntity implements Serializable {
	 private static final long serialVersionUID = -2170897015344177815L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "CELULAR")
    private Long celular;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CICLO")
    private String ciclo;
}
