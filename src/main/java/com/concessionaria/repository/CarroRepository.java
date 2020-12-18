package com.concessionaria.repository;

import org.springframework.data.repository.CrudRepository;
import com.concessionaria.model.Carro;


public interface CarroRepository extends CrudRepository<Carro, Integer> {

	Carro findByCod(Integer cod);
	
}
