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



import com.Irfeyal.app.models.tipo_educacion;
import com.Irfeyal.app.service.Tipo_educacionService;




@RestController
@RequestMapping(path  = "/tipo_educacion")
public class RestTipo_educacionController {
	
	@Autowired
	private Tipo_educacionService tipSer;
	@PostMapping(path="/guardar")
	public tipo_educacion registrarTipo_educacion(@Validated @RequestBody tipo_educacion tipo_educacion){
		return tipSer.crearTipo_educacion(tipo_educacion);
	}
	@GetMapping(path = "/listar")
	public List<tipo_educacion> listar(){
		return tipSer.listar();
	}
	
	@GetMapping(path = "/listar/{nombre}")
	public tipo_educacion buscarpornombre(@PathVariable String nombre) {
		return tipSer.buscarpornombre(nombre);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?>delete(@PathVariable int id){
		tipo_educacion tipo_educacion= tipSer.buscarporid(id);
		if(tipo_educacion==null){
			ResponseEntity.badRequest().build();
		}
		tipSer.eliminarporId(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "editar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<tipo_educacion> updateAula(@PathVariable(value = "id") int id, @RequestBody tipo_educacion tip){
		tipo_educacion actualizar = tipSer.buscarporid(id);
		if(actualizar==null){
			ResponseEntity.badRequest().build();
		}
		
		actualizar.setTip_nombre(tip.getTip_nombre());
		//actualizar.setTip_cod_region(tip.getTip_codigo());
		//actualizar.setMat(mat.getCod_ciclo());
		return ResponseEntity.ok(tipSer.crearTipo_educacion(actualizar));
	}
}
