package com.Irfeyal.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Irfeyal.app.models.tipo_educacion;
import com.Irfeyal.app.repository.Tipo_educacionRepository;

@Service
public class Tipo_educacionService {
	@Autowired
    private Tipo_educacionRepository tipRepo;
    //guardar
    public tipo_educacion crearTipo_educacion(tipo_educacion tip) {
        return tipRepo.save(tip);
    }

    //listar
    public List<tipo_educacion> listar(){
        return tipRepo.findAll();
    }

    //buscar por codigo
    public tipo_educacion buscarpornombre(String nombre) {
        return tipRepo.findbynombre(nombre);
    }
    
    //buscar por id
    public tipo_educacion buscarporid(int id) {
        return tipRepo.findbyId(id);
    }
    
    //eliminar
    public void eliminarporId (int id){
        tipRepo.deleteById(id);
    }
}
