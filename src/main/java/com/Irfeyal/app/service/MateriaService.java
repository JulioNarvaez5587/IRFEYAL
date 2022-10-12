package com.Irfeyal.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Irfeyal.app.models.materia;
import com.Irfeyal.app.repository.MateriaRepo;

@Service
public class MateriaService {
	@Autowired
    private MateriaRepo matRepo;
    //guardar
    public materia crearMateria(materia mat) {
        return matRepo.save(mat);
    }

    //listar
    public List<materia> listar(){
        return matRepo.findAll();
    }

    //buscar por codigo
    public materia buscarpornombre(String nombre) {
        return matRepo.findbynombre(nombre);
    }
    
    //buscar por id
    public materia buscarporid(int id) {
        return matRepo.findbyId(id);
    }
    
    //eliminar
    public void eliminarporId (int id){
        matRepo.deleteById(id);
    }
}
