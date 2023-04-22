package com.nff.insideWorks.insideworksexercise4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Veiculo {
	
	private String placa;
	private Integer chassi;
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Proprietario proprietario;
	

}
