package com.ebacRelacoes.dao;

import com.ebacRelacoes.entidade.Marca;


public interface IMarcaDAO {

	public Marca cadastrar(Marca curso);
	public Marca buscaPorID(Long id);
	public void ExcluirMarca(Marca curso);
	public Marca alterarMarca(Marca curso);
	public java.util.List<Marca> buscarTodosMarca(); 
	
}
