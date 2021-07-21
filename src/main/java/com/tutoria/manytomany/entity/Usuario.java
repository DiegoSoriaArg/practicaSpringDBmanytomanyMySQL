package com.tutoria.manytomany.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "suscripcion",
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "canal_id", referencedColumnName = "id"))
	private Set<Canal> canales = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Canal> getCanales() {
		return canales;
	}

	public void setCanales(Set<Canal> canales) {
		this.canales = canales;
	}
	
	public void subscribe(Canal canal) {
		canales.add(canal);
		canal.getUsuarios().add(this);
	}
	
	public void unsubscribe(Canal canal) {
		canales.remove(canal);
		canal.getUsuarios().remove(this);
	}
	

}
