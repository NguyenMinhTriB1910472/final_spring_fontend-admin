package com.cybersoft.final_springboot.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity(name ="catalog")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy ="catalog")
	private Set<Product> products;
	
	public Catalog() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Catalog(String name) {
		super();
		this.name = name;
	}
	public Catalog(int id, String name) {
		super();
		this.id=id;
		this.name = name;
	}
}
