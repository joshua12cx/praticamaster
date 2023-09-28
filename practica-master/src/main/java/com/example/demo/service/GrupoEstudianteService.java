package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.GrupoEstudianteEntity;

public interface GrupoEstudianteService {
	 GrupoEstudianteEntity create(GrupoEstudianteEntity grupoEstudiante);

	    List<GrupoEstudianteEntity> readAll();

	    GrupoEstudianteEntity update(GrupoEstudianteEntity grupoEstudiante);

	    void delete(Long id);

	    GrupoEstudianteEntity read(Long id);
}
