package com.nff.insideWorks.insideworksexercise4.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nff.insideWorks.insideworksexercise4.domain.enuns.Categoria;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "veiculo", uniqueConstraints = @UniqueConstraint(columnNames = {"placa", "chassi", "cidade"}))
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Nonnull
	private String placa;
	@Nonnull
	private Integer chassi;
	@Nonnull
	private String cidade;
	@Nonnull
	private String marca;
	@Nonnull
	private String modelo;
	@Nonnull
	private Integer ano;
	@Nonnull	
	private Categoria categoria;
	
	@ManyToOne
	@Nonnull
	@JoinColumn(name = "proprietario_id")
	@JsonIgnoreProperties(value = {"veiculo"})
	private Proprietario proprietario;
	

}
