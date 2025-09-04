package com.ebacRelacoes.dao;

import com.ebacRelacoes.entidade.Acessorio;


public interface IAcessoriosDAO {
	
	public Acessorio cadastrar(Acessorio acessorio);
	public Acessorio buscaPorID(Long id);
	public void ExcluirAcessorio(Acessorio acessorio);
	public Acessorio alterarAcessorio(Acessorio acessorio);
	public java.util.List<Acessorio> buscarTodosAcessorio(); 
	
}
