package br.com.hospitalcaldas.services.contract;

import java.util.List;

import br.com.hospitalcaldas.entities.Paciente;

public interface PacienteService {
       Paciente criar (Paciente p);  // validações de negócio + persist
       Paciente atualizar (Paciente p);   // validações de negócio + update
       void excluir (Long id);          // regras de exclusão
       Paciente BuscarPorId (Long id);
       List<Paciente> listar (String filtro);
}
