package br.com.hospitalcaldas.entities;
import br.com.hospitalcaldas.typeEnum.LeitoStatus;

public class Leito {
     
	
	private Long id;
	
	private String identificador;
	
	private LeitoStatus status = LeitoStatus.lIVRE;
	
	private Quarto quarto; // o dono da relacao: tem a coluna de Fk
	
	
	private Long version;
	
	//Regra: somente LIVRE pode receber nova internação.
	
	
	
	
	
	
		    public Leito() {
				// TODO Auto-generated constructor stub
			}
			public Leito(Long id, String identificador, LeitoStatus status, Quarto quarto) {
				super();
				this.id = id;
				this.identificador = identificador;
				this.status = status;
				this.quarto = quarto;
			}

			
						public String getIdentificador() {
							return identificador;
						}
						public void setIdentificador(String identificador) {
							this.identificador = identificador;
						}
						
						
						public LeitoStatus getStatus() {
							return status;
						}
						public void setStatus(LeitoStatus status) {
							this.status = status;
						}
						
						
						public Quarto getQuarto() {
							return quarto;
						}
						public void setQuarto(Quarto quarto) {
							this.quarto = quarto;
						}
						
						
						public Long getId() {
							return id;
			            }
		      
	
	                   
	
	
}
