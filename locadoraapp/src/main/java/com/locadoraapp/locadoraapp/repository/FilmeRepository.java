package com.locadoraapp.locadoraapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.locadoraapp.locadoraapp.models.Filme;

public interface FilmeRepository extends CrudRepository<Filme, String>{
	Filme findByCodigo(long codigo);
}
