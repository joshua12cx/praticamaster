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
import static com.example.demo.commons.GlobalConstans.API_CARRERA;



import com.example.demo.entity.CarreraEntity;
import com.example.demo.service.CarreraService;


@RestController
@RequestMapping(API_CARRERA)
public class CarreraController {

	@Autowired
	private CarreraService carreraService;

	@GetMapping("/all")
	public List<CarreraEntity> listar() {
		return carreraService.readAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarreraEntity> listar2(@PathVariable("id") long id) {
		CarreraEntity prod = carreraService.read(id);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
	@PostMapping("/carrera")
	  public ResponseEntity<CarreraEntity> createTutorial(@RequestBody CarreraEntity c) {
	    try {
	      CarreraEntity car = carreraService.create(new CarreraEntity(c.getId(),c.getNombre(), c.getEstado()));

	      return new ResponseEntity<>(car, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PutMapping("/carrera/{id}")
	public ResponseEntity<CarreraEntity> updateTutorial(@PathVariable("id") long id, @RequestBody CarreraEntity car) {
	    try {
	        CarreraEntity existingCarrera = carreraService.read(id);

	        if (existingCarrera != null) {
	            existingCarrera.setNombre(car.getNombre());
	            existingCarrera.setEstado(car.getEstado());

	            CarreraEntity updatedCarrera = carreraService.update(existingCarrera);

	            return new ResponseEntity<>(updatedCarrera, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@DeleteMapping("/carrera/{id}")
	public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") long id) {
	    try {
	        carreraService.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
