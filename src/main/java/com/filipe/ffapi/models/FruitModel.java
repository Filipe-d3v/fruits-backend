package com.filipe.ffapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class FruitModel {
	
	@EqualsAndHashCode.Include
	@Id
	
	private Long id;
	private String name;
	private String genus;
	private String family;
	private String order;
	
	@OneToOne(mappedBy = "fruitModel", orphanRemoval = true)
	private Nutritions nutritions;
	
	public FruitModel() {
		super();
	}

	public FruitModel( String name, String genus, String family, String order, Nutritions nutritions) {
		super();
		this.name = name;
		this.genus = genus;
		this.family = family;
		this.family = order;
		this.nutritions = nutritions;
	}
	
	
}
