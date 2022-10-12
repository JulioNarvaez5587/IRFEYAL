package com.Irfeyal.app.rest;
import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.Irfeyal.app.models.region;
import com.Irfeyal.app.service.RegionService;



@RestController
@RequestMapping(path  = "/region")
public class RestRegionController {
	@Autowired
	private RegionService regSer;
	@PostMapping(path="/guardar")
	public region registrarRegion(@Validated @RequestBody region reg){
		return regSer.crearRegion(reg);
	}
	@GetMapping(path = "/listar")
	public List<region> listar(){
		return regSer.listar();
	}
	
	@GetMapping(path = "/listar/{nombre}")
	public region buscarpornombre(@PathVariable String nombre) {
		return regSer.buscarpornombre(nombre);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<region>delete(@PathVariable int id){
		Optional<region> reg= regSer.buscarporid(id);
		if(reg==null){
			ResponseEntity.badRequest().build();
		}
		regSer.eliminarporId(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "editar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<region> updateEdificio(@PathVariable(value = "id") int id, @RequestBody region reg){
		Optional<region> actualizar = regSer.buscarporid(id);
		if(actualizar==null){
			ResponseEntity.badRequest().build();
		}
		//actualizar.setReg_nombre(reg.getReg_nombre());
		return ResponseEntity.ok(regSer.crearRegion(reg));
	}
}
