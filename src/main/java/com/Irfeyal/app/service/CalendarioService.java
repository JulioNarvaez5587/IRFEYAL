package com.Irfeyal.app.service;
//Clase de microservicio

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Irfeyal.app.models.calendario;

import com.Irfeyal.app.repository.CalendarioRepo;


import org.springframework.data.domain.Pageable;

@Service
public class CalendarioService {
    @Autowired
    private CalendarioRepo calRepo;
    //guardar
    public calendario crearCalendario(calendario cal) {
        return calRepo.save(cal);
    }

    //listar
    public Page<calendario> listar(Pageable page){
        return calRepo.ordenarPorCodigo(page);
    }
    
    public List<calendario> listarcal() {
        return calRepo.findAll();
    }

    public calendario buscarporcodigo(String codigo) {
    	return calRepo.findbyCodigo(codigo);
    }
    
   // public List<calendario> buscarporfecha(String fecha) {     
    //    return calRepo.findbyfecha_inicio(fecha);
   // }
    
    //buscar por código, bien, calendario
    public Page<calendario> filtrar(String codigo,Pageable page) {
        return calRepo.filtrar(codigo, page);
    }
    
    //buscar no asignados
    public Page<calendario> verAsignado(String asignado,Pageable page) {
        return calRepo.filtrar(asignado, page);
    }
    
    public calendario buscarporid(int id) {
    	return calRepo.findbyId(id);
    }

    //eliminar
    public void eliminarporId (int id){
        calRepo.deleteById(id);
    }
}
