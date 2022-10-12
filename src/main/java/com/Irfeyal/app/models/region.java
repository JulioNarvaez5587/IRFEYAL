package com.Irfeyal.app.models;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.Irfeyal.app.models.tipo_educacion;

@Entity
@Table(name = "region")
public class region {
	@Id
    @Column(name="reg_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "RegionTable")
    private int reg_id;
    @Column(name = "reg_nombre", unique = true)
    private String reg_nombre;
	
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reg_id", cascade = CascadeType.ALL )
    List<tipo_educacion> tip_educ;
    
    
	
    public int getReg_id() {
		return reg_id;
	}

	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}

	public String getReg_nombre() {
		return reg_nombre;
	}

	public void setReg_nombre(String reg_nombre) {
		this.reg_nombre = reg_nombre;
	}


    
    
    
    
}
