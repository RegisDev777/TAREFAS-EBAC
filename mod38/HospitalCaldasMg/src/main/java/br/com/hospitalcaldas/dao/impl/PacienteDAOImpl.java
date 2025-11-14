package br.com.hospitalcaldas.dao.impl;

import java.util.List;
import java.util.Optional;

import br.com.hospitalcaldas.dao.contract.PacienteDAO;
import br.com.hospitalcaldas.entities.Paciente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@ApplicationScoped
public class PacienteDAOImpl implements PacienteDAO{

	
	@PersistenceContext(unitName = "HospitalPU")
	private EntityManager em; // Pu do persistence.xml
	
	
	
	
	
	@Override
	public Paciente save(Paciente p) {
		 if(p.getId() == null) {
			 em.persist(p); return p;
		 } else {
			 return em.merge(p);
		 }
	}

	@Override
	public void delete(Long id) {
		Paciente ref = em.find(Paciente.class, id);
		if(ref != null) em.remove(ref);
		
	}

	@Override
	public Optional<Paciente> findById(Long id) {	 
		return Optional.ofNullable(em.find(Paciente.class, id));
	}

	@Override
	public Optional<Paciente> findByCpf(String cpf) {
		List<Paciente> list = em.createQuery(
				"select p from Paciente p where p.cpf = :cpf", Paciente.class)
				.setParameter("cpf", cpf)
				.getResultList();
		        return list.stream().findFirst();
	}

	@Override
	public List<Paciente> findAll(String filtro) {
		
		String filtroTratado;
		
		 if(filtro == null) {
			 filtroTratado = "";
		 } else {
			 filtroTratado = filtro.trim();
		 }
		
		 String like = "%" +  filtroTratado.toLowerCase() + "%";
		 
		 
		 return em.createQuery(
				 "select p from Paciente p " + 
		         " where lower(p.nome) like :f " +
				 "    or p.cpf like :f " +
		         " order by p.nome", Paciente.class)
				 
				 .setParameter("f", like)
				 .getResultList();
				 
		 
	}

	
	
	
	
}
