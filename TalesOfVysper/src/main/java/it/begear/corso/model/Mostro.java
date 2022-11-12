package it.begear.corso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="mostri")
public class Mostro {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String nomemostro;
	
	@Column(name= "vita")
	private int vita;
	
	@Column(name="attacco")
	private int attacco;
	
	@Column(name="difesa")
	private int difesamostro;
	
	@Column(name="area")
	private String area;

	
	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttacco() {
		return attacco;
	}

	public void setAttacco(int attacco) {
		this.attacco = attacco;
	}


	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNomemostro() {
		return nomemostro;
	}

	public void setNomemostro(String nomemostro) {
		this.nomemostro = nomemostro;
	}

	public int getDifesamostro() {
		return difesamostro;
	}

	public void setDifesamostro(int difesamostro) {
		this.difesamostro = difesamostro;
	}
	
	
	
}
