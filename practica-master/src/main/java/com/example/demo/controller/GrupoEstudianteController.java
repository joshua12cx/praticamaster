package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstans.API_GRUPO_ESTUDIANTE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GrupoEstudianteEntity;
import com.example.demo.service.GrupoEstudianteService;

@RestController
@RequestMapping(API_GRUPO_ESTUDIANTE)
public class GrupoEstudianteController {
	@Autowired
	private GrupoEstudianteService grupoEstudianteService;
	
	 @GetMapping("/all")
	    public List<GrupoEstudianteEntity> listar() {
	        return grupoEstudianteService.readAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<GrupoEstudianteEntity> listarPorId(@PathVariable("id") Long id) {
	    	GrupoEstudianteEntity grupoEstudiante = grupoEstudianteService.read(id);
	        if (grupoEstudiante != null) {
	            return new ResponseEntity<>(grupoEstudiante, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping("/grupo-estudiante")
	    public ResponseEntity<GrupoEstudianteEntity> crearGrupoEstudiante(@RequestBody GrupoEstudianteEntity grupoEstudiante) {
	        try {
	        	GrupoEstudianteEntity creado = grupoEstudianteService.create(grupoEstudiante);
	            return new ResponseEntity<>(creado, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PutMapping("/grupo-estudiante/{id}")
	    public ResponseEntity<GrupoEstudianteEntity> actualizarGrupoEstudiante(@PathVariable("id") Long id, @RequestBody GrupoEstudianteEntity grupoEstudiante) {
	        try {
	        	GrupoEstudianteEntity existente = grupoEstudianteService.read(id);

	            if (existente != null) {
	               
	                existente.setNombre(grupoEstudiante.getNombre());
	                existente.setEstado(grupoEstudiante.getEstado());
	                existente.setLiderGrupo(grupoEstudiante.getLiderGrupo());
	                existente.setLimiteFinProyecto(grupoEstudiante.getLimiteFinProyecto());

	                GrupoEstudianteEntity actualizado = grupoEstudianteService.update(existente);

	                return new ResponseEntity<>(actualizado, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @DeleteMapping("/grupo-estudiante/{id}")
	    public ResponseEntity<HttpStatus> eliminarGrupoEstudiante(@PathVariable("id") Long id) {
	        try {
	            grupoEstudianteService.delete(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
}

