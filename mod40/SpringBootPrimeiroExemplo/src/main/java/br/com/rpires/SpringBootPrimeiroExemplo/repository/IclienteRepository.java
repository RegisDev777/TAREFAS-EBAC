package br.com.rpires.SpringBootPrimeiroExemplo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rpires.SpringBootPrimeiroExemplo.domain.Cliente;

public interface IclienteRepository extends CrudRepository<Cliente, Long> {

}
