package br.com.rpires.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rpires.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	
}
