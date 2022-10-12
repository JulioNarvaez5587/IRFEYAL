package com.Irfeyal.app.models;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ciclo")
public class ciclo {
	@Id
    @Column(name="cicl_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CicloTable")
    private int cicl_id;
	@Column(name = "cicl_nombre", unique = true)
    private String cicl_nombre;
    @Column(name = "descripcion_ciclo")
    private String cicl_des;
    @Column(name = "cod_tip_educacion")
    private String cod_tip_educacion;
	

	public int getCicl_id() {
		return cicl_id;
	}

	public void setCicl_id(int cicl_id) {
		this.cicl_id = cicl_id;
	}

	public String getCicl_nombre() {
		return cicl_nombre;
	}

	public void setCicl_nombre(String cicl_nombre) {
		this.cicl_nombre = cicl_nombre;
	}

	public String getCicl_des() {
		return cicl_des;
	}

	public void setCicl_des(String cicl_des) {
		this.cicl_des = cicl_des;
	}

	public String getCod_tip_educacion() {
		return cod_tip_educacion;
	}

	public void setCod_tip_educacion(String cod_tip_educacion) {
		this.cod_tip_educacion = cod_tip_educacion;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "ciclo", cascade = CascadeType.ALL)
	private materia materias;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo_edu", cascade = CascadeType.ALL)
	private tipo_educacion tipo_edu;

    
	
       
}
