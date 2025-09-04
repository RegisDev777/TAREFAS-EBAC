package com.exemplo.testeDAO;



import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;

import com.ebacRelacoes.dao.AcessorioDao;
import com.ebacRelacoes.dao.CarroDao;
import com.ebacRelacoes.dao.IAcessoriosDAO;
import com.ebacRelacoes.dao.ICarroDAO;
import com.ebacRelacoes.dao.IMarcaDAO;
import com.ebacRelacoes.dao.MarcaDao;
import com.ebacRelacoes.entidade.Acessorio;
import com.ebacRelacoes.entidade.Carro;
import com.ebacRelacoes.entidade.Marca;
import com.ebacRelacoes.enuns.MarcaEnuns;
import com.ebacRelacoes.enuns.Modificacoes;

import junit.framework.Assert;

public class CarroDAOTest {

	private ICarroDAO carroDAO;
	private IMarcaDAO marcaDAO;
	private IAcessoriosDAO acessoriosDAO;
	
	public CarroDAOTest() {
		this.carroDAO = new CarroDao();
		this.marcaDAO = new MarcaDao();
		this.acessoriosDAO = new AcessorioDao();
	}
	
	       private Marca criarMarca(MarcaEnuns nome) {
	    	    Marca m = new Marca();
	            m.setMarca(nome);
	            return marcaDAO.cadastrar(m);
	       }	
	       private Acessorio criarAcessorioTunning(Modificacoes mod) {
	           Acessorio acessorio = new Acessorio();
	             acessorio.setEnumModificacoes(mod);
	           return acessoriosDAO.cadastrar(acessorio);
	       }
	       private Carro criarCarro() {
	    	   Marca mercedes = criarMarca(MarcaEnuns.MERCEDES);
	    	   Acessorio acessorio = criarAcessorioTunning(Modificacoes.BRABUS);
	    	    Carro carro = new Carro();
	    	       
	    	       carro.setModelo("CLS");
	    	       carro.setAno(2025);
	    	       carro.setMarca(mercedes);
	    	       carro.addAcessorio(acessorio);
	    	    return carro;       	       
	       }
	       private Carro CarroCompleto() {
	    	    Carro carroPronto = criarCarro();    	    
	    	    return carroDAO.cadastrar(carroPronto);
	       }
	
	       
	       @Test
	       public void cadastrar() {
	    	    Carro c = CarroCompleto();
	    	    Assert.assertNotNull(c.getId());  
	    	    
	    	    Carro db = carroDAO.buscaPorId(c.getId());
	    	    Assert.assertEquals("CLS", db.getModelo());
	    	    Assert.assertEquals(Integer.valueOf(2025), db.getAno());
	    	    Assert.assertEquals(MarcaEnuns.MERCEDES, db.getMarca().getMarca());	    	    
	       }
	
	
	   	@After
	   	public void end() {
	   		carroDAO.BuscarTodosOsCarros().forEach(c -> carroDAO.excluirCarro(c));
	   		acessoriosDAO.buscarTodosAcessorio().forEach(a -> acessoriosDAO.ExcluirAcessorio(a));
	   		marcaDAO.buscarTodosMarca().forEach(m -> marcaDAO.ExcluirMarca(m));
	   	}
	
}
