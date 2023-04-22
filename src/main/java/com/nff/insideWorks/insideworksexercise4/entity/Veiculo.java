package com.nff.insideWorks.insideworksexercise4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "veiculo", uniqueConstraints = @UniqueConstraint(columnNames = {"chassi", "cidade"}))
public class Veiculo {
	
	@Id
	private String placa;
	private Integer chassi;
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Proprietario proprietario;
	

}
