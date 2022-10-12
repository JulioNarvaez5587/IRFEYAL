package com.Irfeyal.app.rest;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.Irfeyal.app.models.calendario;

import com.Irfeyal.app.service.*;
@RestController
@RequestMapping(path  = "/calendario")
public class RestCalendarioController {
	@Autowired
	private CalendarioService calSer;
	
	@CrossOrigin
	@ResponseBody
	@PostMapping(path="/guardar")
	public calendario registrarCalendario(@Validated @RequestBody calendario cal){
		return calSer.crearCalendario(cal);
	}
	
	@GetMapping(path = "/listar")
	public Page<calendario> listar(Pageable page) {
        return this.calSer.listar(page);
    }
	
	@GetMapping(path = "/listarcal")//lista los Calendarios
    public List<calendario> ListarCal() {
    	return calSer.listarcal();
    }
	
  //  @GetMapping(path = "/listcal/{fecha_inicio}")
	//public List<calendario> buscarporparam(@PathVariable String fecha_inicio) {
	//	return calSer.buscarporcodigo(fecha_inicio)
	//}
    
	@GetMapping(path = "/listar/{texto}")
	public Page<calendario> buscar(@PathVariable String texto, Pageable page) {
        return this.calSer.filtrar(texto, page);
    }
	
	@GetMapping(path = "/listar/asignado/{asignado}")
	public Page<calendario> buscarporAsignado(@PathVariable String asignado,Pageable page) {
		return calSer.verAsignado(asignado, page);
	}
    
	@GetMapping(path = "/listar/codigo/{codigo}")
	public calendario buscarporCodigo(@PathVariable String codigo) {
		return calSer.buscarporcodigo(codigo);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?>delete(@PathVariable int id){
		calendario art = calSer.buscarporid(id);
		if(art==null){
			ResponseEntity.badRequest().build();
		}
		calSer.eliminarporId(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "editar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<calendario> updateArticulo(@PathVariable(value = "id") int id, @RequestBody calendario cal){
		calendario actualizar = calSer.buscarporid(id);
		if(actualizar==null){
			ResponseEntity.badRequest().build();
		}
		actualizar.setCal_codigo(cal.getCal_codigo());
		actualizar.setFecha_inicio(cal.getFecha_inicio());
		//actualizar.setCal_fe_ini(cal.getCal_fe_ini());
		actualizar.setHora_inicio(cal.getHora_inicio());
		//actualizar.setCal_ho_ini(cal.getCal_ho_ini());
		actualizar.setHora_final(cal.getHora_final());
		//actualizar.setCal_ho_fin(cal.getCal_ho_fin());
		
		return ResponseEntity.ok(calSer.crearCalendario(actualizar));
	}
        
        @PutMapping(value = "editar/codigo/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<calendario> updateCalendarioCodigo(@PathVariable(value = "codigo") String codigo, @RequestBody String cal){
		calendario actualizar = calSer.buscarporcodigo(codigo);
		if(actualizar==null){
			ResponseEntity.badRequest().build();
		}
		//actualizar.setCal_asignado(cal);
		return ResponseEntity.ok(calSer.crearCalendario(actualizar));
	}
}
