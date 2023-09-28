package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GrupoEstudianteEntity;
import com.example.demo.repository.GrupoEstudianteRepository;
import com.example.demo.service.GrupoEstudianteService;

@Service
public class GrupoEstudianteServiceImpl implements GrupoEstudianteService {

	
	@Autowired
	private GrupoEstudianteRepository grupoEstudianteRepository;
	@Override
	public GrupoEstudianteEntity create(GrupoEstudianteEntity grupoEstudiante) {
		// TODO Auto-generated method stub
		return grupoEstudianteRepository.save(grupoEstudiante);
	}

	@Override
	public List<GrupoEstudianteEntity> readAll() {
		// TODO Auto-generated method stub
		return grupoEstudianteRepository.findAll();
	}

	@Override
	public GrupoEstudianteEntity update(GrupoEstudianteEntity grupoEstudiante) {
		// TODO Auto-generated method stub
		return grupoEstudianteRepository.save(grupoEstudiante);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		grupoEstudianteRepository.deleteById(id);
	}

	@Override
	public GrupoEstudianteEntity read(Long id) {
		// TODO Auto-generated method stub
		return grupoEstudianteRepository.findById(id).get();
	}

}
