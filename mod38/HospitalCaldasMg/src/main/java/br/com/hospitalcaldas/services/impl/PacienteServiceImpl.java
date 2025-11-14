package br.com.hospitalcaldas.services.impl;

import br.com.hospitalcaldas.dao.contract.PacienteDAO;
import br.com.hospitalcaldas.entities.Paciente;
import br.com.hospitalcaldas.services.contract.PacienteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PacienteServiceImpl implements PacienteService {

    @Inject
    private PacienteDAO dao;

    @Override
    @Transactional
    public Paciente criar(Paciente p) {
        // Regra: CPF único
        dao.findByCpf(p.getCpf()).ifPresent(x -> {
            throw new IllegalArgumentException("Já existe paciente com este CPF.");
        });
        return dao.save(p);
    }

    @Override
    @Transactional
    public Paciente atualizar(Paciente p) {
        // Regra: CPF único (não pode colidir com outro registro)
        dao.findByCpf(p.getCpf()).ifPresent(x -> {
            if (!x.getId().equals(p.getId())) {
                throw new IllegalArgumentException("CPF já utilizado por outro paciente.");
            }
        });
        return dao.save(p);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        // Futuro: bloquear se houver internações ativas
        dao.delete(id);
    }

    
    @Override
	public Paciente BuscarPorId(Long id) {
		  return dao.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado."));
	}
    
    @Override
    public List<Paciente> listar(String filtro) {
        return dao.findAll(filtro);
    }

	
}
