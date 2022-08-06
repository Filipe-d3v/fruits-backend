package com.filipe.ffapi.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.filipe.ffapi.dtos.FruitDTO;
import com.filipe.ffapi.models.FruitModel;
import com.filipe.ffapi.servicies.FruitService;

@RestController
@RequestMapping(value = "/fruits")
public class FruitController {
	
	@Autowired
	private FruitService fService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<FruitDTO> findById(@PathVariable Long id){
		FruitModel obj = fService.findById(id);
		FruitDTO objDTO = new FruitDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<FruitDTO>> findAll(){
		List<FruitDTO> listDTO = fService.findAll().stream().map(obj -> new FruitDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping("/cadatrar")
	public ResponseEntity<FruitDTO> create( @RequestBody FruitDTO objDTO){
		FruitModel newObj = fService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
}
