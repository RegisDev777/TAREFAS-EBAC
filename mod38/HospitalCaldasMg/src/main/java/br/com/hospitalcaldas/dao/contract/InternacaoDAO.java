package br.com.hospitalcaldas.dao.contract;

import java.util.List;
import java.util.Optional;

import br.com.hospitalcaldas.entities.Internacao;

public interface InternacaoDAO {
	
		/**
	     * Cria ou atualiza uma internação.
	     * Se id for null, faz INSERT; senão, faz UPDATE.
	     */
		Internacao save(Internacao internacao);
			
		/**
	     * "Exclui" a internação.
	     * Implementação fará soft delete (ativo = false).
	     */
		void delete(long id);	

	    /**
	     * Busca uma internação pelo id.
	     */
		Optional<Internacao> findById(Long id);
		
		 /**
	     * Lista todas as internações ativas (ativo = true).
	     */
		List<Internacao> findAllAtivas();
		
		/**
	     * Lista todas as internações (ativas ou não) de um paciente.
	     */
		List<Internacao>findByPaciente(Long pacienteId);	
       
       
       
       
}
