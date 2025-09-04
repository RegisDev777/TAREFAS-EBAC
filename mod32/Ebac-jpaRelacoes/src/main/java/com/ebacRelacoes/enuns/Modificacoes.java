package com.ebacRelacoes.enuns;

import java.util.Set;

public enum Modificacoes {
     AMG("AMG"),
     BRABUS("brabus"),
     MANSORY("Mansory"),
     LORINSER("Lorinser"),
     KICHERER("Kicherer");
	
	   private final String descricao;
	   
	       Modificacoes(String descricao) {
			this.descricao =  descricao;
		  }
	  
	      public String getDescricao() {
			return descricao;
		  }
	    
	      @Override
	    public String toString() {
	    	return descricao;
	    }
}
