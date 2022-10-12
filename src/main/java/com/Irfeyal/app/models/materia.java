package com.Irfeyal.app.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "materia")
public class materia {
	@Id
    @Column(name="mat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "MateriaTable")
    private int mat_id;
	@Column(name = "mat_nombre", unique = true)
    private String mat_nombre;
    @Column(name = "mat_descripcion")
    private String mat_descripcion;
    @Column(name = "cod_ciclo")
    private String cod_ciclo;
    @Column(name = "video_id")
    private String video_id;
    
    @ManyToMany
	@JoinColumn(name = "mat_id")
	private materia materia;
    
//	@ManyToMany
	//@JoinColumn(name = "video_id")
	//private video video2;
    @ManyToMany(mappedBy = "video")
    List<video>video2;
    
    @ManyToMany(mappedBy = "materia")
    List<ciclo>ciclo;
    
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	@OneToMany
	@JoinColumn(name = "video_id")
	private video video;
	
	

	public int getMat_id() {
		return mat_id;
	}

	public void setMat_id(int mat_id) {
		this.mat_id = mat_id;
	}

	public String getMat_nombre() {
		return mat_nombre;
	}

	public void setMat_nombre(String mat_nombre) {
		this.mat_nombre = mat_nombre;
	}

	public String getMat_descripcion() {
		return mat_descripcion;
	}

	public void setMat_descripcion(String mat_descripcion) {
		this.mat_descripcion = mat_descripcion;
	}

	public String getCod_ciclo() {
		return cod_ciclo;
	}

	public void setCod_ciclo(String cod_ciclo) {
		this.cod_ciclo = cod_ciclo;
	}

	//public List<video> getVideo() {
	//	return video;
	//}

	//public void setVideo(List<video> video) {
		//this.video = video;
	//}

	//public List<ciclo> getCiclo() {
		//return ciclo;
	//}

	///public void setCiclo(List<ciclo> ciclo) {
		//this.ciclo = ciclo;
	//}
    
    
}
