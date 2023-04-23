package com.nff.insideWorks.insideworksexercise4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nff.insideWorks.insideworksexercise4.domain.Proprietario;
import com.nff.insideWorks.insideworksexercise4.repository.ProprietarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	public List<Proprietario> findAll(){
		return proprietarioRepository.findAll();
	}
	
	public Optional<Proprietario> findById(Long id) {
		return proprietarioRepository.findById(id);
	}
	
	public Proprietario insert(Proprietario proprietario){
		return proprietarioRepository.save(proprietario);
	}
	
	public Proprietario update(Long id, Proprietario proprietario) {
		try {
		 Proprietario entity = proprietarioRepository.getReferenceById(id);
		 updateData(entity, proprietario);
		 return proprietarioRepository.save(entity);
		}catch(EntityNotFoundException e ) {
			e.printStackTrace();
		}
		return proprietario;		 
	}
	
	 private void updateData(Proprietario entity, Proprietario proprietario) {
	        entity.setNome(proprietario.getNome());
	        entity.setCpf(proprietario.getCpf());
	        entity.setVeiculo(proprietario.getVeiculo());

	    }
	 
	 public void delete(Long id) {
		 proprietarioRepository.deleteById(id);
	 }
}
