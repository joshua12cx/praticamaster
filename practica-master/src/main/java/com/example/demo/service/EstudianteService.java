package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EstudianteEntity;

public interface EstudianteService {
	EstudianteEntity create(EstudianteEntity estudiante);

    List<EstudianteEntity> readAll();

    EstudianteEntity update(EstudianteEntity estudiante);

    void delete(Long id);

    EstudianteEntity read(Long id);
}
