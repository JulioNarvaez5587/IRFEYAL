package com.Irfeyal.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.proyecto.models.categorias;
import com.Irfeyal.app.models.tipo_educacion;
//import com.proyecto.models.categorias;
//import com.proyecto.models.categorias;

@Repository
public interface Tipo_educacionRepository extends JpaRepository<tipo_educacion, Integer> {
	// Busca por nombre
    @Query(value = "select * from tipo_educacion where tip_nombre=?",nativeQuery = true)
    tipo_educacion findbynombre(String tip_nombre);
    
    // Busca por id para editar
    @Query(value = "select * from tipo_educacion where tip_id=?",nativeQuery = true)
    tipo_educacion findbyId(int tip_id);

    // Eliminar por id
    @Transactional
    @Modifying
    @Query(value="delete from tipo_educacion where tip_id=?", nativeQuery =true)
    int deleteById(int tip_id);
}
