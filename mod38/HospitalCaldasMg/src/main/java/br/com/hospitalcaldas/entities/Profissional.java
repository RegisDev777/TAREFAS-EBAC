package br.com.hospitalcaldas.entities;

import br.com.hospitalcaldas.typeEnum.TipoCargo;

public class Profissional {
  
	 private Long id;
	 
	 private String nome;
	 
	 private TipoCargo tipo;
	 
	 private String registroConselho;
	 
	 		
	 			public Profissional() {
					// TODO Auto-generated constructor stub
	 			}
				public Profissional(Long id, String nome, TipoCargo tipo, String registroConselho) {
					super();
					this.id = id;
					this.nome = nome;
					this.tipo = tipo;
					this.registroConselho = registroConselho;
				}
					
				       
				        public String getNome() {
							return nome;
						}
						public void setNome(String nome) {
							this.nome = nome;
						}
						
						
						public TipoCargo getTipo() {
							return tipo;
						}
						public void setTipo(TipoCargo tipo) {
							this.tipo = tipo;
						}
						
						
						public String getRegistroConselho() {
							return registroConselho;
						}
						public void setRegistroConselho(String registroConselho) {
							this.registroConselho = registroConselho;
						}
						
						
						public Long getId() {
							return id;
						}
	            
	  
						
	    
}
