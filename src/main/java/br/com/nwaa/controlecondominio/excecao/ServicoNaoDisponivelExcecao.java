package br.com.nwaa.controlecondominio.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ServicoNaoDisponivelExcecao extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ServicoNaoDisponivelExcecao() {
		super();
	}
}