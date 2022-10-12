package com.Irfeyal.app.models;
//Clase para crear la tabla tipo de educacion

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_educacion")
public class tipo_educacion {
	@Id
    @Column(name="tip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TipoEducacionTable")
    private int tip_id;
    @Column(name = "tip_codigo", unique=true)
    private String tip_codigo;
    @Column(name = "tip_nombre")
    private String tip_nombre;
    @Column(name = "reg_id")
    private int reg_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "reg_id")
  	private region region;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tip_id")
	private ciclo ciclo_tip_edu;
	//////////////////////////////////////////////////
   // @OneToMany(mappedBy= "ciclo")
  //  List<ciclo>ciclo;
    ///////////////////////////////////////////////////
 //   @OneToMany(mappedBy= "region")
   // List<region>region;
	public int getTip_id() {
		return tip_id;
	}
	public void setTip_id(int tip_id) {
		this.tip_id = tip_id;
	}
	public String getTip_codigo() {
		return tip_codigo;
	}
	public void setTip_codigo(String tip_codigo) {
		this.tip_codigo = tip_codigo;
	}
	public String getTip_nombre() {
		return tip_nombre;
	}
	public void setTip_nombre(String tip_nombre) {
		this.tip_nombre = tip_nombre;
	}
	public int getReg_id() {
		return reg_id;
	}
	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}


	//public List<ciclo> getCiclo() {
	//	return ciclo;
	//}

	//public void setCiclo(List<ciclo> ciclo) {
	//	this.ciclo = ciclo;
	//}
    
}
