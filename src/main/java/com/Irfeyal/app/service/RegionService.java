package com.Irfeyal.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Irfeyal.app.models.region;
import com.Irfeyal.app.repository.RegionRepo;

@Service
public class RegionService {
	@Autowired
    private RegionRepo regRepo;
    //guardar
    public region crearRegion(region reg) {
        return regRepo.save(reg);
    }

    //listar
    public List<region> listar(){
        return regRepo.findAll();
    }

    //buscar por codigo
    public region buscarpornombre(String nombre) {
        return regRepo.findbynombre(nombre);
    }
    
    //buscar por id
    public Optional<region> buscarporid(int id) {
        return regRepo.findById(id);
    }
    
    //eliminar
    public void eliminarporId (int id){
        regRepo.deleteById(id);
    }
}
