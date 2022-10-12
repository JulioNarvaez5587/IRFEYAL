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

import com.Irfeyal.app.models.video;


import com.Irfeyal.app.service.VideoService;




@RestController
@RequestMapping(path  = "/video")
public class RestVideoController {
	
	@Autowired
	private VideoService videoSer;
	@PostMapping(path="/guardar")
	public video registrarVideo(@Validated @RequestBody video video){
		return videoSer.crearVideo(video);
	}
	@GetMapping(path = "/listar")
	public List<video> listar(){
		return videoSer.listar();
	}
	
	@GetMapping(path = "/listar/{nombre}")
	public video buscarpornombre(@PathVariable String nombre) {
		return videoSer.buscarpornombre(nombre);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?>delete(@PathVariable int id){
		video video= videoSer.buscarporid(id);
		if(video==null){
			ResponseEntity.badRequest().build();
		}
		videoSer.eliminarporId(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "editar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<video> updateAula(@PathVariable(value = "id") int id, @RequestBody video vid){
		video actualizar = videoSer.buscarporid(id);
		if(actualizar==null){
			ResponseEntity.badRequest().build();
		}
		actualizar.setVideo_nombre(vid.getVideo_nombre());
		actualizar.setVideo_id(vid.getVideo_id());
		//return ResponseEntity.ok(vidSer.crearVideo(actualizar));
		return ResponseEntity.ok(videoSer.crearVideo(actualizar));
	}
}
