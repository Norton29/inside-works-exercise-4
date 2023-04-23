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

import com.nff.insideWorks.insideworksexercise4.domain.Veiculo;
import com.nff.insideWorks.insideworksexercise4.service.VeiculoService;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll() {
		return ResponseEntity.ok()
				.body(veiculoService.findAll());
	}
	
	@GetMapping(value = {"/id"})
	public ResponseEntity<Optional<Veiculo>> findById(@PathVariable Long id){
		return ResponseEntity.ok()
				.body(veiculoService.findById(id));
	}
	
	@PostMapping
    public ResponseEntity<Veiculo> insert(@RequestBody Veiculo veiculoParam) {
        Veiculo veiculo = veiculoService.insert(veiculoParam);        
        return ResponseEntity.ok().body(veiculo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Veiculo> delete(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody Veiculo veiculo) {
          return ResponseEntity.ok()
        		  .body(veiculoService.update(id, veiculo));
    }

}
