package com.Irfeyal.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.Irfeyal.app.models.materia;
@Entity
@Table(name = "Video")

public class video {
	@Id
    @Column(name="video_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "VideoTable")
    private int video_id;
	@Column(name = "video_nombre", unique = true)
    private String video_nombre;
	@Column(name = "video_descripcion")
	private String video_descripcion;
	@Column(name = "video_direccion")
	private String video_direccion;
	@Column(name = "cal_id")
	private String cal_id;
	@Column(name = "mat_id")
	private int mat_id;
	

	
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getVideo_nombre() {
		return video_nombre;
	}
	public void setVideo_nombre(String video_nombre) {
		this.video_nombre = video_nombre;
	}
	public String getVideo_descripcion() {
		return video_descripcion;
	}
	public void setVideo_descripcion(String video_descripcion) {
		this.video_descripcion = video_descripcion;
	}
	public String getVideo_direccion() {
		return video_direccion;
	}
	public void setVideo_direccion(String video_direccion) {
		this.video_direccion = video_direccion;
	}
	public String getCal_codigo() {
		return cal_id;
	}
	public void setCal_codigo(String cal_id) {
		this.cal_id= cal_id;
	}
	public int getMat_id() {
		return mat_id;
	}
	public void setMat_id(int mat_id) {
		this.mat_id = mat_id;
	}
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "cal_id")
	//private calendario calendario;
	
	
	@ManyToOne
	@JoinColumn(name = "cal_id")
	private calendario calendario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "video", cascade = CascadeType.ALL)
//	@JoinColumn
	private materia materia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mat_id")
	private materia materia1;
	//@ManyToMany 
	//private video video;

	

//	public calendario getCalendario() {
	//	return calendario;
	//}

	//public void setCalendario(calendario calendario) {
		//this.calendario = calendario;
	//}

	//public video getVideo() {
	//	return video;
	//}

	//public void setVideo(video video) {
	//	this.video = video;
	//}
	
	
}
