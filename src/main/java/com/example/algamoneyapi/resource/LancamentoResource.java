package com.example.algamoneyapi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoneyapi.model.Lancamento;
import com.example.algamoneyapi.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	
	@GetMapping
	public List<Lancamento> Listar(){
		return lancamentoRepository.findAll();
	}
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable long codigo){
		Optional<Lancamento> lancamento = lancamentoRepository.findById(codigo);
		
		return lancamento.isPresent() ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}
	
}
