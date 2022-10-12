package com.Irfeyal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.proyecto.models.categorias;

import com.Irfeyal.app.models.materia;


	@Repository
	public interface MateriaRepo extends JpaRepository<materia, Integer> {
		// Busca por nombre
	    @Query(value = "select * from materia where mat_nombre=?",nativeQuery = true)
	    materia findbynombre(String mat_nombre);
	    
	    // Busca por id para editar
	    @Query(value = "select * from materia where mat_id=?",nativeQuery = true)
	    materia findbyId(int cat_id);

	    // Eliminar por id
	    @Transactional
	    @Modifying
	    @Query(value="delete from materia where mat_id=?", nativeQuery =true)
	    int deleteById(int mat_id);
}
