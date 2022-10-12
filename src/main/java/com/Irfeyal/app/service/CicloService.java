package com.Irfeyal.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Irfeyal.app.models.ciclo;
import com.Irfeyal.app.repository.CicloRepo;


@Service
public class CicloService {
	@Autowired
    private CicloRepo ciclRepo;
    //guardar
    public ciclo crearCiclo(ciclo cicl) {
        return ciclRepo.save(cicl);
    }

    //listar
    public List<ciclo> listar(){
        return ciclRepo.findAll();
    }

    //buscar por codigo
    public ciclo buscarpornombre(String nombre) {
        return ciclRepo.findbynombre(nombre);
    }
    
    //buscar por id
    public ciclo buscarporid(int id) {
        return ciclRepo.findbyId(id);
    }
    
    //eliminar
    public void eliminarporId (int id){
        ciclRepo.deleteById(id);
    }
}
