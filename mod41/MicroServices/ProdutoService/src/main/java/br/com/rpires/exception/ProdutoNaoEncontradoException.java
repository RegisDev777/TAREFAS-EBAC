package br.com.rpires.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {

	
	public ProdutoNaoEncontradoException() {
		super("Produto nao encontrado");
	}
	
	
}
