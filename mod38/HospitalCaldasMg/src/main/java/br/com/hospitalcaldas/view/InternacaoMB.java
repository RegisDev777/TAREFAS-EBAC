package br.com.hospitalcaldas.view;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import br.com.hospitalcaldas.entities.Internacao;
import br.com.hospitalcaldas.services.contract.InternacaoService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Managed Bean da tela de Internação.
 * - Faz a ponte entre a TELA (JSF) e o SERVICE.
 * - Não fala direto com o banco, só com InternacaoService.
 */
@Named("internacaoMB")
@ViewScoped
public class InternacaoMB implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private InternacaoService internacaoService;
	
	
	     private Long pacienteId;
	     private LocalDate dataEntrada;
	     private String motivo;
	     private String observacoes;
	     
	     private List<Internacao> internacoesAtivas;
	     
	     
	     		public void carregarInternacoesAtivas() {
	     			internacoesAtivas = internacaoService.listarAtivas();
	     		}
	     		
	     		public void internar() {
	     			internacaoService.internarPaciente(pacienteId, dataEntrada, motivo, observacoes);
	     			
	     	         limparFormulario(); //limpa campos do formulario
	     	         
	     	         carregarInternacoesAtivas(); //recarregar a lista da tabela
	     			
	     		}
	     
	            public void darAlta (Long internacaoID) {
	            	internacaoService.darAlta(internacaoID, LocalDate.now(), "Alta registrada pela tela");
	            	carregarInternacoesAtivas();
	            }
	     
	     
	                     //getters e setters 
	            public InternacaoService getInternacaoService() {
					return internacaoService;
				}
				public void setInternacaoService(InternacaoService internacaoService) {
					this.internacaoService = internacaoService;
				}

				public Long getPacienteId() {
					return pacienteId;
				}
				public void setPacienteId(Long pacienteId) {
					this.pacienteId = pacienteId;
				}

				public LocalDate getDataEntrada() {
					return dataEntrada;
				}
				public void setDataEntrada(LocalDate dataEntrada) {
					this.dataEntrada = dataEntrada;
				}

				public String getMotivo() {
					return motivo;
				}
				public void setMotivo(String motivo) {
  				 this.motivo = motivo;
				}
				
				public String getObservacoes() {
					return observacoes;
				}
				public void setObservacoes(String observacoes) {
					this.observacoes = observacoes;
				}

				public List<Internacao> getInternacoesAtivas() {
					return internacoesAtivas;
				}
				public void setInternacoesAtivas(List<Internacao> internacoesAtivas) {
					this.internacoesAtivas = internacoesAtivas;
				}

				public static long getSerialversionuid() {
					return serialVersionUID;
				}  
	     
	     		
	     		
	     		//metodos
	     		
	     		private void limparFormulario() {
	     		  dataEntrada = null;
	     		  motivo = null;
	     		  observacoes = null;
	     		  pacienteId = null;    			
	     		}

				
	     
	     
	     
	     
	
	
}
