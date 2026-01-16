package br.com.rpires.exception;

public class ClienteNaoEncontradoException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException() {
        super("Cliente nao encontrado");
    }
}
