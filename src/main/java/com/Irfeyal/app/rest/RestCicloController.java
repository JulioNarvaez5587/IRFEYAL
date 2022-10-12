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



import com.Irfeyal.app.models.ciclo;
import com.Irfeyal.app.service.CicloService;


@RestController
@RequestMapping(path  = "/ciclo")
public class RestCicloController {
	@Autowired
	private CicloService ciclSer;
	@PostMapping(path="/guardar")
	public ciclo registrarCiclo(@Validated @RequestBody ciclo cicl){
		return ciclSer.crearCiclo(cicl);
	}
	@GetMapping(path = "/listar")
	public List<ciclo> listar(){
		return ciclSer.listar();
	}
	
	@GetMapping(path = "/listar/{nombre}")
	public ciclo buscarpornombre(@PathVariable String nombre) {
		return ciclSer.buscarpornombre(nombre);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?>delete(@PathVariable int id){
		ciclo cicl = ciclSer.buscarporid(id);
		if(cicl==null){
			ResponseEntity.badRequest().build();
		}
		ciclSer.eliminarporId(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "editar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ciclo> updateCiclo(@PathVariable(value = "id") int id, @RequestBody ciclo cicl){
		ciclo actualizar = ciclSer.buscarporid(id);
		if(actualizar==null){
			ResponseEntity.badRequest().build();
		}
		actualizar.setCicl_nombre(cicl.getCicl_nombre());
		actualizar.setCicl_des(cicl.getCicl_des());
		//actualizar.setCicl(cicl.getCicl_id());
		return ResponseEntity.ok(ciclSer.crearCiclo(actualizar));
	}
}
