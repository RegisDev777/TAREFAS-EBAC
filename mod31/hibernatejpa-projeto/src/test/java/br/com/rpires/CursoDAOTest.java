package br.com.rpires;

	import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.com.pires.domain.Curso;
import br.com.rpires.dao.CursoDao;
import br.com.rpires.dao.ICursoDao;



	public class CursoDAOTest {
		
		private ICursoDao cursoDao;
		
		public CursoDAOTest() {
			cursoDao = new CursoDao();
		}
		
		private Curso criarCurso() {
			Curso curso = new Curso();
			curso.setCodigo("A1");
			curso.setDescricao("Curso de java BackEnd");
			curso.setNome("BackEnd Java Pro");
			
			
			curso = cursoDao.cadastrar(curso);	
			return curso;
		}
		
		@After
		public void end() {
			List<Curso> list = cursoDao.buscarTodosCurso();
			list.forEach(cli -> cursoDao.ExcluirCurso(cli));
		}

		
		@Test
		public void cadastrar() {
			Curso curso = criarCurso();
			assertNotNull(curso);
			
			Curso cursoDB = cursoDao.buscaPorID(curso.getId());
			assertNotNull(cursoDB);
			assertEquals(curso.getId(), cursoDB.getId());
			assertEquals(curso.getNome(), cursoDB.getNome());
			
//			clienteDAO.excluir(cliente);
//			Cliente clienteDBEx = clienteDAO.buscarPorID(cliente.getId());
//			assertNull(clienteDBEx);
		}

		@Test
		public void alterar() {
			Curso curso = criarCurso();
			assertNotNull(curso);
			
			Curso cursoDB = cursoDao.buscaPorID(curso.getId());
			assertNotNull(cursoDB);
			assertEquals(curso.getId(), cursoDB.getId());
			assertEquals(curso.getNome(), cursoDB.getNome());
			
			cursoDB.setNome("Rodrigo Pires");
			Curso cursoUp = cursoDao.alterarCurso(cursoDB);
			assertEquals("Rodrigo Pires", cursoUp.getNome());
			
//			clienteDAO.excluir(cliente);
//			Cliente clienteDBEx = clienteDAO.buscarPorID(cliente.getId());
//			assertNull(clienteDBEx);
			
		}
		

}
