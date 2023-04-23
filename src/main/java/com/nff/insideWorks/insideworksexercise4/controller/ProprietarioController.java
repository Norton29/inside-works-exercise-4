package com.nff.insideWorks.insideworksexercise4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nff.insideWorks.insideworksexercise4.domain.Proprietario;
import com.nff.insideWorks.insideworksexercise4.service.ProprietarioService;

@RestController
@RequestMapping(value = "/proprietario")
public class ProprietarioController {

	@Autowired
	private ProprietarioService proprietarioService;

	@GetMapping
	public ResponseEntity<List<Proprietario>> findAll() {
		return ResponseEntity.ok()
				.body(proprietarioService.findAll());
	}
	
	@GetMapping(value = {"/id"})
	public ResponseEntity<Optional<Proprietario>> findById(@PathVariable Long id){
		return ResponseEntity.ok()
				.body(proprietarioService.findById(id));
	}
	
	@PostMapping
    public ResponseEntity<Proprietario> insert(@RequestBody Proprietario proprietarioParam) {
        Proprietario proprietario = proprietarioService.insert(proprietarioParam);        
        return ResponseEntity.ok().body(proprietario);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Proprietario> delete(@PathVariable Long id) {
        proprietarioService.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Proprietario> update(@PathVariable Long id, @RequestBody Proprietario proprietario) {
          return ResponseEntity.ok()
        		  .body(proprietarioService.update(id, proprietario));
    }

}
