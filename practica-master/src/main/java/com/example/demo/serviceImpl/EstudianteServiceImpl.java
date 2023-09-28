package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EstudianteEntity;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService{
 
	@Autowired
	private EstudianteRepository estudianteRepository;
	@Override
	public EstudianteEntity create(EstudianteEntity estudiante) {
		// TODO Auto-generated method stub
		return estudianteRepository.save(estudiante);
	}

	@Override
	public List<EstudianteEntity> readAll() {
		// TODO Auto-generated method stub
		return estudianteRepository.findAll();
	}

	@Override
	public EstudianteEntity update(EstudianteEntity estudiante) {
		// TODO Auto-generated method stub
		return estudianteRepository.save(estudiante);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		estudianteRepository.deleteById(id);
	}

	@Override
	public EstudianteEntity read(Long id) {
		// TODO Auto-generated method stub
		return estudianteRepository.findById(id).get();
	}

}
