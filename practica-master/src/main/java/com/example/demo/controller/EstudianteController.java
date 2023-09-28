package com.example.demo.controller;

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
import static com.example.demo.commons.GlobalConstans.API_ESTUDIANTE;

import com.example.demo.entity.EstudianteEntity;
import com.example.demo.service.EstudianteService;

@RestController
@RequestMapping(API_ESTUDIANTE)
public class EstudianteController {
	@Autowired
    private EstudianteService estudianteService;
	@GetMapping("/all")
    public List<EstudianteEntity> listar() {
        return estudianteService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteEntity> listarPorId(@PathVariable("id") long id) {
        EstudianteEntity estudiante = estudianteService.read(id);
        if (estudiante != null) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/estudiante")
    public ResponseEntity<EstudianteEntity> crearEstudiante(@RequestBody EstudianteEntity estudiante) {
        try {
            EstudianteEntity creado = estudianteService.create(estudiante);
            return new ResponseEntity<>(creado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/estudiante/{id}")
    public ResponseEntity<EstudianteEntity> actualizarEstudiante(@PathVariable("id") long id, @RequestBody EstudianteEntity estudiante) {
        try {
            EstudianteEntity existente = estudianteService.read(id);

            if (existente != null) {
                existente.setNombre(estudiante.getNombre());
                existente.setCodigo(estudiante.getCodigo());
                existente.setCelular(estudiante.getCelular());
                existente.setEmail(estudiante.getEmail());
                existente.setCiclo(estudiante.getCiclo());

                EstudianteEntity actualizado = estudianteService.update(existente);

                return new ResponseEntity<>(actualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/estudiante/{id}")
    public ResponseEntity<HttpStatus> eliminarEstudiante(@PathVariable("id") long id) {
        try {
            estudianteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
