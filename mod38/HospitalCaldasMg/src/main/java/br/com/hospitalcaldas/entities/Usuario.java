package br.com.hospitalcaldas.entities;

import br.com.hospitalcaldas.typeEnum.TipoCargo;

public class Usuario {

	private Long id;
	private String userName;
	private String senhaHash;
	private TipoCargo perfil;
	
	
	
	         public Usuario() {
				// TODO Auto-generated constructor stub
			 }
			 public Usuario(Long id, String userName, String senhaHash, TipoCargo perfil) {
				super();
				this.id = id;
				this.userName = userName;
				this.senhaHash = senhaHash;
				this.perfil = perfil;
			 }
					
			       public Long getId() {
						return id;
					}
					public void setId(Long id) {
						this.id = id;
					}
					public String getUserName() {
						return userName;
					}
					public void setUserName(String userName) {
						this.userName = userName;
					}
					public String getSenhaHash() {
						return senhaHash;
					}
					public void setSenhaHash(String senhaHash) {
						this.senhaHash = senhaHash;
					}
					public TipoCargo getPerfil() {
						return perfil;
					}
					public void setPerfil(TipoCargo perfil) {
						this.perfil = perfil;
					}
			         
	                  
	              
	
	
	
	
}
