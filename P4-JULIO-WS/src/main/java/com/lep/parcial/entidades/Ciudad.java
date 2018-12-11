package com.lep.parcial.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="ciudad")
public class Ciudad {
	
	@Id
	@GeneratedValue
	private  int id;
	private String nombre;
	private String pais;
	private float num_habitantes;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public float getNum_habitantes() {
		return num_habitantes;
	}
	public void setNum_habitantes(float num_habitantes) {
		this.num_habitantes = num_habitantes;
	}
	public Ciudad(int id, String nombre, String pais, float num_habitantes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.num_habitantes = num_habitantes;
	}
	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", num_habitantes=" + num_habitantes
				+ "]";
	}
	
	

}
