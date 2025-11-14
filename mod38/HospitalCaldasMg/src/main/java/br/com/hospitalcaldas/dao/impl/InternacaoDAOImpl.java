package br.com.hospitalcaldas.dao.impl;

import java.util.List;
import java.util.Optional;

import br.com.hospitalcaldas.dao.contract.InternacaoDAO;
import br.com.hospitalcaldas.entities.Internacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.resource.cci.Interaction;


@ApplicationScoped
public class InternacaoDAOImpl implements InternacaoDAO {

	@PersistenceContext(unitName = "HospitalPU")
	private EntityManager em;
	
	
	@Override
	public Internacao save(Internacao internacao) {
		 if(internacao.getId() == null) {
			 em.persist(internacao);
			 return internacao;
		 } else {
			 return em.merge(internacao);
		 }	
	}

	@Override
	public void delete(long id) {
	    Internacao internacao = em.find(Internacao.class, id);
	    if(internacao != null) {
	    	internacao.setAtivo(false);
	    	em.merge(internacao);
	    }		
	}

	@Override
	public Optional<Internacao> findById(Long id) {
		Internacao internacao = em.find(Internacao.class, id);
		return Optional.ofNullable(internacao);
	}

	@Override
	public List<Internacao> findAllAtivas() {
	    return em.createQuery(
                "select i from Internacao i " +
                " where i.ativo = true " +
                " order by i.dataEntrada desc",
                Internacao.class
        ).getResultList();
	}

	@Override
	public List<Internacao> findByPaciente(Long pacienteId) {
		 return em.createQuery(
	                "select i from Internacao i " +
	                " where i.paciente.id = :idPaciente " +
	                " order by i.dataEntrada desc",
	                Internacao.class
	        )
	        .setParameter("idPaciente", pacienteId)
	        .getResultList();
	    }
	

	
	
     
	
}
