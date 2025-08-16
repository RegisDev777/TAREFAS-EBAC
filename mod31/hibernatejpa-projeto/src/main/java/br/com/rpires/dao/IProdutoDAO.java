package br.com.rpires.dao;

import br.com.pires.domain.Produto;

public interface IProdutoDAO {
	public Produto cadastar(Produto p);
	public Produto buscaPorID(Long id);
	public void ExcluirProduto(Produto p);
	public Produto alterarProduto(Produto p);
	public java.util.List<Produto> buscarTodosProduto();
}
