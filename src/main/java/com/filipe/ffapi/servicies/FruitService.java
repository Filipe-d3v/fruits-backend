package com.filipe.ffapi.servicies;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.ffapi.controllers.exceptions.ViolationException;
import com.filipe.ffapi.dtos.FruitDTO;
import com.filipe.ffapi.models.FruitModel;
import com.filipe.ffapi.repositories.FruitRepository;

@Service
public class FruitService {

	@Autowired
	private FruitRepository fRepository;
	
	public FruitModel findById(Long id) {
		Optional<FruitModel> obj = fRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + FruitModel.class.getName(), null));
	}
	
	public List<FruitModel> findAll() {
		return fRepository.findAll();
	}
	
	public FruitModel create( FruitDTO objDTO) {
		if(findByName(objDTO) != null) {
			throw new ViolationException("Fruta já cadastrada!");
		}
		return  fRepository.save(new FruitModel( objDTO.getName(), objDTO.getGenus(), objDTO.getFamily(), objDTO.getOrder(), objDTO.getNutritions()));
	}
	
	private FruitModel findByName(FruitDTO objDTO) {
		FruitModel obj = fRepository.findByName(objDTO.getName());

		if (obj != null) {
			return obj;
		}
		return null;
	}
}
