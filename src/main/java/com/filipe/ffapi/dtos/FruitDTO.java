package com.filipe.ffapi.dtos;

import com.filipe.ffapi.models.FruitModel;
import com.filipe.ffapi.models.Nutritions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FruitDTO {

	private Long id;
	private String name;
	private String genus;
	private String family;
	private String order;
	private Nutritions nutritions;
	
	public FruitDTO() {
		super();
	}

	public FruitDTO(FruitModel obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.genus = obj.getGenus();
		this.family = obj.getFamily();
		this.order = obj.getOrder();
		this.nutritions = obj.getNutritions();
	}
	
	
}
