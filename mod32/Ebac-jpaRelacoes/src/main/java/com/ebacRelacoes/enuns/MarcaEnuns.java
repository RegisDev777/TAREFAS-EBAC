package com.ebacRelacoes.enuns;

public enum MarcaEnuns {
    LEXUS("lexus"),
    ASTON_MARTIN("Aston martin"),
    MERCEDES("mercedes bens"),
    BMW("bmw"),
    LAMBORGHINI("lamborghini");
	
	private final String descricao;
			   
		    MarcaEnuns(String descricao) {
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
