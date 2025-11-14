package br.com.hospitalcaldas.entities;

import java.util.ArrayList;
import java.util.List;

public class Quarto {

	private Long id;
	
	private String numero;
	
	private Integer andar;
	
	private String observacao;
	
	private List<Leito> leitos = new ArrayList<>(); //UM quarto tem varios leitos
	
	
	                    public Quarto() {
							// TODO Auto-generated constructor stub
	                    }
						public Quarto(Long id, String numero, Integer andar, String observacao, List<Leito> leitos) {
							this.id = id;
							this.numero = numero;
							this.andar = andar;
							this.observacao = observacao;
							this.leitos = leitos;
						}
						
						
						public String getNumero() {
							return numero;
						}
						public void setNumero(String numero) {
							this.numero = numero;
						}
						
						
						public Integer getAndar() {
							return andar;
						}
						public void setAndar(Integer andar) {
							this.andar = andar;
						}
						
						
						public String getObservacao() {
							return observacao;
						}
						public void setObservacao(String observacao) {
							this.observacao = observacao;
						}
						
						
						public List<Leito> getLeitos() {
							return leitos;
						}
						public void setLeitos(List<Leito> leitos) {
							this.leitos = leitos;
						}
						
						
						public Long getId() {
							return id;
						}
	                    
	        
						
	
	
	
}
