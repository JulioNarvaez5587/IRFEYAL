package com.Irfeyal.app.models;
//import java.util.List;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//En esta clase creamos la tabla calendario
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "calendario")
public class calendario {
	  @Id
	    @Column(name="cal_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CalendarioTable")
	    private int cal_id;
	    @Column(name = "cal_codigo", unique=true)
	    private String cal_codigo;
	    @Column(name = "fecha_inicio")
	    private String fecha_inicio;
	    @Column(name = "hora_inicio")
	    private String hora_inicio;
	    @Column(name = "hora_final")
	    private String hora_final;
	    
	    
		
		public int getCal_id() {
			return cal_id;
		}
		public void setCal_id(int cal_id) {
			this.cal_id = cal_id;
		}
		public String getCal_codigo() {
			return cal_codigo;
		}
		public void setCal_codigo(String cal_codigo) {
			this.cal_codigo = cal_codigo;
		}
		public String getFecha_inicio() {
			return fecha_inicio;
		}
		public void setFecha_inicio(String fecha_inicio) {
			this.fecha_inicio = fecha_inicio;
		}
		public String getHora_inicio() {
			return hora_inicio;
		}
		public void setHora_inicio(String hora_inicio) {
			this.hora_inicio = hora_inicio;
		}
		public String getHora_final() {
			return hora_final;
		}
		public void setHora_final(String hora_final) {
			this.hora_final = hora_final;
		}
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "video_id")
		private video video;
		
		//@OneToMany(fetch = FetchType.LAZY, mappedBy = "calendario",cascade = CascadeType.ALL)
		//List<video> video;
		
		
		//public List<video> getVideo() {
			//return video;
		///}
		//public void setVideo(List<video> video) {
			//this.video = video;
		//}
	    
		
		
	    
}
