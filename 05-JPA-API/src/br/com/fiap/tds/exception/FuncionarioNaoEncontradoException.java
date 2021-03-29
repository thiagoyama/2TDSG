package br.com.fiap.tds.exception;

public class FuncionarioNaoEncontradoException extends Exception {

	public FuncionarioNaoEncontradoException() {
		super("Funcionário não encontrado");
	}
	
	public FuncionarioNaoEncontradoException(String msg) {
		super(msg);
	}
	
}