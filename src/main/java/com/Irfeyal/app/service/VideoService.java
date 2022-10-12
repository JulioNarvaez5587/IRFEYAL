package com.Irfeyal.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.Irfeyal.app.models.video;
import com.Irfeyal.app.repository.VideoRepo;

@Service
public class VideoService {
	@Autowired
    private VideoRepo videoRepo;
    //guardar
    public video crearVideo(video video) {
        return videoRepo.save(video);
    }

    //listar
    public List<video> listar(){
        return videoRepo.findAll();
    }

    //buscar por nombre
    public video buscarpornombre(String nombre) {
        return videoRepo.findbynombre(nombre);
    }
    
    //buscar por id
    public video buscarporid(int id) {
        return videoRepo.findbyId(id);
    }
    
    //eliminar
    public void eliminarporId (int id){
    	videoRepo.deleteById(id);
    }
}
