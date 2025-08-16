package br.com.rpires;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;


import br.com.pires.domain.Produto;
import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.dao.ProdutoDAO;

public class ProdutoDAOTest {
	

	private IProdutoDAO produtoDAO;
	
	public ProdutoDAOTest() {
		produtoDAO = new ProdutoDAO();
	}
	
	private Produto criarProduto() {
		Produto p = new Produto();
		p.setNome("Iphone");
		p.setPreco(4000d);
		p.setDescricao("VERSAO gold, 250 gb");
		p = produtoDAO.cadastar(p);	
		return p;
	}
	
	@After
	public void end() {
		List<Produto> list = produtoDAO.buscarTodosProduto();
		list.forEach(cli -> produtoDAO.ExcluirProduto(cli));
	}

	
	@Test
	public void cadastrar() {
		Produto p = criarProduto();
		assertNotNull(p);
		
		Produto produtoDB = produtoDAO.buscaPorID(p.getId());
		assertNotNull(produtoDB);
		assertEquals(p.getId(), produtoDB.getId());
		assertEquals(p.getNome(), produtoDB.getNome());
		
//		clienteDAO.excluir(cliente);
//		Cliente clienteDBEx = clienteDAO.buscarPorID(cliente.getId());
//		assertNull(clienteDBEx);
	}


	@Test
	public void alterar() {
		Produto p = criarProduto();
		assertNotNull(p);
		
		Produto produtoDB = produtoDAO.buscaPorID(p.getId());
		assertNotNull(produtoDB);
		assertEquals( p.getId(), produtoDB.getId());
		assertEquals( p.getNome(), produtoDB.getNome());
		
		produtoDB.setNome("Rodrigo Pires");
		Produto produtoUp = produtoDAO.alterarProduto(produtoDB);
		assertEquals("Rodrigo Pires", produtoUp.getNome());
		
//		clienteDAO.excluir(cliente);
//		Cliente clienteDBEx = clienteDAO.buscarPorID(cliente.getId());
//		assertNull(clienteDBEx);
		
	}
	
	
	
}
