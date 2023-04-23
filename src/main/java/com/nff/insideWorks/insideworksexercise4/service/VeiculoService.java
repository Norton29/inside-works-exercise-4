package com.nff.insideWorks.insideworksexercise4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nff.insideWorks.insideworksexercise4.domain.Veiculo;
import com.nff.insideWorks.insideworksexercise4.repository.VeiculoRepository;
import com.nff.insideWorks.insideworksexercise4.service.exception.CustomException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<Veiculo> findAll(){
		return veiculoRepository.findAll();
	}
	
	public Optional<Veiculo> findById(Long id) {
		return veiculoRepository.findById(id);
	}
	
	public Veiculo insert(Veiculo veiculo){
		try {
		return veiculoRepository.save(veiculo);
		}catch(RuntimeException e) {
		throw new CustomException(veiculo.getPlaca());
		}
	}
	
	public Veiculo update(Long id, Veiculo veiculo) {
		try {
		 Veiculo entity = veiculoRepository.getReferenceById(id);
		 updateData(entity, veiculo);
		 return veiculoRepository.save(entity);
		}catch(EntityNotFoundException e ) {
			e.printStackTrace();
		}
		return veiculo;		 
	}
	
	 private void updateData(Veiculo entity, Veiculo veiculo) {
	        entity.setPlaca(veiculo.getPlaca());
	        entity.setChassi(veiculo.getChassi());
	        entity.setCidade(veiculo.getCidade());
	        entity.setCategoria(veiculo.getCategoria());
	        entity.setMarca(veiculo.getMarca());
	        entity.setModelo(veiculo.getModelo());
	        entity.setAno(veiculo.getAno());
	        entity.setProprietario(veiculo.getProprietario());

	    }
	 
	 public void delete(Long id) {
		 veiculoRepository.deleteById(id);
	 }
}
