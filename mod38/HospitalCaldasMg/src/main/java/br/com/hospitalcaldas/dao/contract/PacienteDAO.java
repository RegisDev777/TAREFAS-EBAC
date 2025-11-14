package br.com.hospitalcaldas.dao.contract;

import java.util.List;
import java.util.Optional;

import br.com.hospitalcaldas.entities.Paciente;

public interface PacienteDAO {

	Paciente save (Paciente p);  //cria/atualiza
	void delete (Long id);  //remove por id
	Optional<Paciente> findById(Long id); //busca por id
	Optional<Paciente> findByCpf(String cpf); //unicidade
	List<Paciente> findAll (String filtro); //lista com filtro por nome cpf
	
}
