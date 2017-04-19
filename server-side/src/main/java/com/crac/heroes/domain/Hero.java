package com.crac.heroes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="heroes")
public class Hero {
	
	
	@NotEmpty
	@NotNull
	@Column(name="name")
	String name;

	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id; 
	
	
	public Hero(){}
	
	public Hero(String n, Long i){
		name = n;
		id = i;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
