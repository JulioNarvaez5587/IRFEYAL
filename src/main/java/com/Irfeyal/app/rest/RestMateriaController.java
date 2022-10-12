package com.Irfeyal.app.rest;
import java.util.List;

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



import com.Irfeyal.app.models.materia;
import com.Irfeyal.app.service.MateriaService;


@RestController
@RequestMapping(path  = "/materia")
public class RestMateriaController {
	@Autowired
	private MateriaService matSer;
	@PostMapping(path="/guardar")
	public materia registrarMateria(@Validated @RequestBody materia mat){
		return matSer.crearMateria(mat);
	}
	@GetMapping(path = "/listar")
	public List<materia> listar(){
		return matSer.listar();
	}
	
	@GetMapping(path = "/listar/{nombre}")
	public materia buscarpornombre(@PathVariable String nombre) {
		return matSer.buscarpornombre(nombre);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?>delete(@PathVariable int id){
		materia mat = matSer.buscarporid(id);
		if(mat==null){
			ResponseEntity.badRequest().build();
		}
		matSer.eliminarporId(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "editar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<materia> updateMateria(@PathVariable(value = "id") int id, @RequestBody materia mat){
		materia actualizar = matSer.buscarporid(id);
		if(actualizar==null){
			ResponseEntity.badRequest().build();
		}
		actualizar.setMat_nombre(mat.getMat_nombre());
		actualizar.setMat_descripcion(mat.getMat_descripcion());
		//actualizar.setMat(mat.getCod_ciclo());
		return ResponseEntity.ok(matSer.crearMateria(actualizar));
	}
}
