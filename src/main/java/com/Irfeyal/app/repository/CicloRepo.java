package com.Irfeyal.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import com.Irfeyal.app.models.ciclo;
@Repository
public interface CicloRepo  extends JpaRepository<ciclo, Integer>  {
	// Busca por nombre
    @Query(value = "select * from ciclo where cicl_nombre=?",nativeQuery = true)
    ciclo findbynombre(String cicl_nombre);
    
    // Busca por id para editar
    @Query(value = "select * from ciclo where cicl_id=?",nativeQuery = true)
    ciclo findbyId(int cicl_id);

    // Eliminar por id
    @Transactional
    @Modifying
    @Query(value="delete from ciclo where cicl_id=?", nativeQuery =true)
    int deleteById(int cicl_id);
}
