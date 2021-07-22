package br.com.systemsgs.exception;

public class FalhaServicoOpenFeignException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public FalhaServicoOpenFeignException() {
		super("Ops! Serviço de Clientes está Fora ou Erro Interno!!!");
	}

}
