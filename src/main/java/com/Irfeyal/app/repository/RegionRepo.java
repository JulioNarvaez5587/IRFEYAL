package com.Irfeyal.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Irfeyal.app.models.region;

//import com.proyecto.models.aula;

//import com.proyecto.models.aula;
//import com.Irfeyal.app.models.video;

@Repository
public interface RegionRepo extends JpaRepository<region, Integer>{
	// Busca por nombre
    @Query(value = "select * from region where nombre=?",nativeQuery = true)
    region findbynombre(String nombre);
    
    // Busca por id para editar
    @Query(value = "select * from region where region_id=?",nativeQuery = true)
    region findbyId(int reigion_id);

    // Eliminar por id
    @Transactional
    @Modifying
    @Query(value="delete from region where region_id=?", nativeQuery =true)
    int deleteById(int reg_id);
}
