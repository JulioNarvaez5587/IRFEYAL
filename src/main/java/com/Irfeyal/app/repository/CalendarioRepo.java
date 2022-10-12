package com.Irfeyal.app.repository;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Irfeyal.app.models.calendario;


@Repository
public interface CalendarioRepo extends JpaRepository<calendario, Integer>{
	@Query(value = "select a from calendario a order by fecha_inicio asc")
    Page<calendario> ordenarPorCodigo(Pageable page);
	//////////////////////////////////////////////////////////////////////////////////////////////////////
    // Busca por codigo
	//@Query(value = "select a from calendario a where a.cal_codigo like %:text% or a.cal_id like %:text% or a.art_empresa like %:text% or a.art_aula like %:text% or a.art_asignado like %:text% or a.art_numero_acta like %:text% or a.art_serie like %:text% or a.art_cod_anterior like %:text% or a.art_bld like %:text% or a.art_modelo like %:text% or a.art_dimensiones like %:text% or a.art_marca like %:text% or a.art_color like %:text% or a.art_material like %:text% or a.art_descripcion like %:text% or a.art_cuenta_contable like %:text% or a.art_fecha_ing like %:text% or a.art_fecha_depre like %:text% or a.art_valor_contable like %:text% or a.art_observacion like %:text% or a.art_conciliacion like %:text% or a.art_estado like %:text% or a.art_categoria like %:text%")
	@Query(value = "select a from calendario a where fecha_inicio ")
	Page<calendario> filtrar(@Param("text") String text, Pageable page);
	
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // ver no asignados
   // @Query(value = "select a from calendario a where a.art_asignado like %:text%")
   // Page<calendario> filtrar_asignado(@Param("text") String text, Pageable page);
    
   // @Query(value = "select a from articulo a where a.art_codigo like %:text% or a.art_bien like %:text% or a.art_empresa like %:text% or a.art_aula like %:text% or a.art_asignado like %:text%")
   // List<calendario> findbyfecha_inicio(@Param("text") String text);
    
    // Busca por id para editar
    @Query(value = "select * from calendario where cal_id=?",nativeQuery = true)
    calendario findbyId(int cal_id);

 // Busca por codigo
    @Query(value = "select * from calendario where cal_codigo=?",nativeQuery = true)
    calendario findbyCodigo(String cal_codigo);
    
    // Eliminar por id
    @Transactional
    @Modifying
    @Query(value="delete from calendario where cal_id=?", nativeQuery =true)
    int deleteById(int cal_id);
}
