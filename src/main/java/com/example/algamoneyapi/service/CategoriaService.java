package com.example.algamoneyapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoneyapi.model.Categoria;
import com.example.algamoneyapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Optional<Categoria> categoriaSalva = categoriaRepository.findById(codigo);
		
		if(!categoriaSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		categoria.setCodigo(codigo);
		return categoriaRepository.save(categoria);
	}
}
