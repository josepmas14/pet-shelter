package com.josep.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josep.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{
	Optional<Pet> findByName(String name);
}
