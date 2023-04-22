package com.nff.insideWorks.insideworksexercise4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Proprietario {

	private String nome;
	
	@OneToMany(mappedBy = "proprietario")
	private Veiculo veiculo;
	
}
