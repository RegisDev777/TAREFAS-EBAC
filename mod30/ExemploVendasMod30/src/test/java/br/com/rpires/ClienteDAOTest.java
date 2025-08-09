/**
 * Ajustado para JUnit 5 (Jupiter)
 */
package br.com.rpires;

import static org.junit.jupiter.api.Assertions.*; // assertTrue, assertNotNull, assertEquals, assertNull

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.rpires.dao.ClienteDAO;
import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {
	
	private final IClienteDAO clienteDao;

	public ClienteDAOTest() {
		this.clienteDao = new ClienteDAO();
	}
	
	@AfterEach
	void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		for (Cliente cli : list) {
			clienteDao.excluir(cli.getCpf());
		}
	}
	
	@Test
	void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setEmail("Ro@gmail.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		clienteDao.cadastrar(cliente);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setEmail("Ro@gmail.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setEmail("Ro@gmail.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		assertNull(clienteConsultado);
	}
	
	@Test
	void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setEmail("Ro@gmail.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Rodrigo Pires");
		clienteDao.alterar(clienteConsultado);
		
		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
		assertNotNull(clienteAlterado);
		assertEquals("Rodrigo Pires", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		assertNull(clienteConsultado);
	}
	
	@Test
	void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setEmail("Ro@gmail.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		assertTrue(retorno);
		
		Cliente cliente1 = new Cliente();
		cliente1.setCpf(56565656569L);
		cliente1.setNome("Rodrigo");
		cliente1.setCidade("São Paulo");
		cliente1.setEnd("End");
		cliente1.setEstado("SP");
		cliente1.setEmail("Ro@gmail.com");
		cliente1.setNumero(10);
		cliente1.setTel(1199999999L);
		Boolean retorno1 = clienteDao.cadastrar(cliente1);
		assertTrue(retorno1);
		
		Collection<Cliente> list = clienteDao.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());
		
		for (Cliente cli : list) {
			clienteDao.excluir(cli.getCpf());
		}
		
		Collection<Cliente> list1 = clienteDao.buscarTodos();
		assertNotNull(list1);
		assertEquals(0, list1.size());
	}
}
