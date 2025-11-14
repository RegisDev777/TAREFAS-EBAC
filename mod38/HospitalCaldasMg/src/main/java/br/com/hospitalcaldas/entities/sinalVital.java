package br.com.hospitalcaldas.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class sinalVital {

	private Long id;
	private Internacao internacao;
    private Profissional profissional;
    private LocalDate dataHora;
    private String pressaoArterial;
    private Integer frequenciaCardiaca;
    private Integer frequenciaRespiratoria;
    private BigDecimal temperatura;
    private Integer ipo2;
      
                public sinalVital() {
					// TODO Auto-generated constructor stub
				}
				public sinalVital(Long id, Internacao internacao, Profissional profissional, LocalDate dataHora,
						String pressaoArterial, Integer frequenciaCardiaca, Integer frequenciaRespiratoria,
						BigDecimal temperatura, Integer ipo2) {
					super();
					this.id = id;
					this.internacao = internacao;
					this.profissional = profissional;
					this.dataHora = dataHora;
					this.pressaoArterial = pressaoArterial;
					this.frequenciaCardiaca = frequenciaCardiaca;
					this.frequenciaRespiratoria = frequenciaRespiratoria;
					this.temperatura = temperatura;
					this.ipo2 = ipo2;
				}
				
				
						public Internacao getInternacao() {
							return internacao;
						}
						public void setInternacao(Internacao internacao) {
							this.internacao = internacao;
						}
						
						
						public Profissional getProfissional() {
							return profissional;
						}
						public void setProfissional(Profissional profissional) {
							this.profissional = profissional;
						}
						
						
						public LocalDate getDataHora() {
							return dataHora;
						}
						public void setDataHora(LocalDate dataHora) {
							this.dataHora = dataHora;
						}
						
						
						public String getPressaoArterial() {
							return pressaoArterial;
						}
						public void setPressaoArterial(String pressaoArterial) {
							this.pressaoArterial = pressaoArterial;
						}
						
						
						public Integer getFrequenciaCardiaca() {
							return frequenciaCardiaca;
						}
						public void setFrequenciaCardiaca(Integer frequenciaCardiaca) {
							this.frequenciaCardiaca = frequenciaCardiaca;
						}
						
						
						public Integer getFrequenciaRespiratoria() {
							return frequenciaRespiratoria;
						}
						public void setFrequenciaRespiratoria(Integer frequenciaRespiratoria) {
							this.frequenciaRespiratoria = frequenciaRespiratoria;
						}
						
						
						public BigDecimal getTemperatura() {
							return temperatura;
						}
						public void setTemperatura(BigDecimal temperatura) {
							this.temperatura = temperatura;
						}
						
						
						public Integer getIpo2() {
							return ipo2;
						}
						public void setIpo2(Integer ipo2) {
							this.ipo2 = ipo2;
						}
						
						
						public Long getId() {
							return id;
						}
	             
	
						
				
				
				
				
				
				
	
}
