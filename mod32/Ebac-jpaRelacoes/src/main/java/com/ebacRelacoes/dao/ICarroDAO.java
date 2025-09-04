package com.ebacRelacoes.dao;

import java.util.List;

import com.ebacRelacoes.entidade.Carro;

public interface ICarroDAO {

	public Carro cadastrar(Carro carro);
	public Carro buscaPorId (Long id);
	public void  excluirCarro(Carro carro);
	public Carro alterarCarro(Carro carro);
	public List<Carro> BuscarTodosOsCarros();
	
}
