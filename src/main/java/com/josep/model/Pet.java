package com.josep.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Pet {
	//Mascota[id,nombre,fechaNac,raza,peso,tiene_chip,url_foto]
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@NonNull
	private String race;
	
	@NonNull
	private double weight;
	
	@NonNull
	@Column(name = "has_chip")
	private boolean hasChip;
	
	@Column(name = "url_picture")
	@NonNull
	private String urlPicture;
	
	public Pet() {
		
	}
	
}
