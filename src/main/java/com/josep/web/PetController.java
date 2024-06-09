package com.josep.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.josep.data.PetRepository;
import com.josep.model.Pet;


@RestController
@RequestMapping("/api")
public class PetController {

	@Autowired
	PetRepository petRepository;
		
	@GetMapping("/pet")
	List<Pet> getAllPets(){
		return (List<Pet>) petRepository.findAll();
	}
	
	@GetMapping("/pet/{id}")
	public ResponseEntity<Pet> petByID(@PathVariable Long id){
		Optional<Pet> optPet = petRepository.findById(id);
		if(optPet.isPresent()) {
			return new ResponseEntity<>(optPet.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(path="/pet", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Pet createPet(@RequestBody Pet pet) {
		return petRepository.save(pet);
	}
	
    @PutMapping("/pet")
    public Pet updatePet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }
		
    @DeleteMapping("/pet/{id}")
    public void deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
    }
		
	@GetMapping("/pet/recents")
	public Iterable<Pet> youngestPets(){
		PageRequest page = PageRequest.of(0, 20, Sort.by("dateOfBirth").descending());
		return petRepository.findAll(page);
	}
	
	@GetMapping("/pet/{pag}/5")
	public Iterable<Pet> showPetsByPage(@PathVariable int pag){
		PageRequest page = PageRequest.of(pag, 5);
		return petRepository.findAll(page);
	}
		
	@GetMapping("/pet/byname/{name}")
	public ResponseEntity<Pet> petByName(@PathVariable String name){
		Optional<Pet> optPet = petRepository.findByName(name);
		if(optPet.isPresent()) {
			return new ResponseEntity<>(optPet.get(), HttpStatus.OK);
		} 
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
