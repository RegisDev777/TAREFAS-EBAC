package br.com.rpires.dao;

import br.com.pires.domain.Curso;

public interface ICursoDao {
 
	public Curso cadastrar(Curso curso);
	public Curso buscaPorID(Long id);
	public void ExcluirCurso(Curso curso);
	public Curso alterarCurso(Curso curso);
	public java.util.List<Curso> buscarTodosCurso();
	
}
