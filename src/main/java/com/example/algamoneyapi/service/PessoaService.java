package com.example.algamoneyapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
	
		buscarPessoaPeloCodigo(codigo);
		
		pessoa.setCodigo(codigo);
		return pessoaRepository.save(pessoa);
			
	}

	public void atualizarPropriedadeAtivo(Long codigo, boolean ativo) {
	
		Optional<Pessoa> pessoaSalva = buscarPessoaPeloCodigo(codigo);
		
		Pessoa pessoa = pessoaSalva.get();
		pessoa.setAtivo(ativo);
		
		pessoaRepository.save(pessoa);
		
	}
	
	private Optional<Pessoa> buscarPessoaPeloCodigo(Long codigo) {
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);
		if(!pessoaSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}
	
}
