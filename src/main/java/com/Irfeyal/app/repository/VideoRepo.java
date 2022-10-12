package com.Irfeyal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.proyecto.models.aula;
import com.Irfeyal.app.models.video;
//import com.proyecto.models.aula;

@Repository
public interface VideoRepo  extends JpaRepository<video, Integer>{
	// Busca por nombre
    @Query(value = "select * from video where nombre=?",nativeQuery = true)
    video findbynombre(String nombre);
    
    // Busca por id para editar
    @Query(value = "select * from video where video_id=?",nativeQuery = true)
    video findbyId(int edif_id);

    // Eliminar por id
    @Transactional
    @Modifying
    @Query(value="delete from video where video_id=?", nativeQuery =true)
    int deleteById(int vid_id);
}
