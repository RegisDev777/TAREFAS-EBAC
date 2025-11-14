package br.com.hospitalcaldas.view;

import java.io.Serializable;
import java.util.List;

import br.com.hospitalcaldas.entities.Paciente;
import br.com.hospitalcaldas.services.contract.PacienteService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;



@Named("pacienteMB")
@ViewScoped
public class PacienteMB  implements Serializable{

	
	@Inject
	private PacienteService service;
	
	private String filtro;
	private Paciente atual = new Paciente();
	
	
	public List<Paciente> getPacientes(){
		return service.listar(filtro);
	}
	
	public void novo() {
		atual = new Paciente();
	}
	
	public void salvar () {
		if(atual.getId() == null) {
			service.criar(atual);
		} else {
			service.atualizar(atual);
		}
		novo();
	}
		
	public void editar(Paciente p) {
		this.atual = p;
	}
		
	public void excluir(Long id){
		service.excluir(id);
	}
	
	
	
				public String getFiltro() {
					return filtro;
				}
				public void setFiltro(String filtro) {
					this.filtro = filtro;
				}				
				
				public Paciente getAtual() {
					return atual;
				}
				public void setAtual(Paciente atual) {
							this.atual = atual;
				}
				
				
}
