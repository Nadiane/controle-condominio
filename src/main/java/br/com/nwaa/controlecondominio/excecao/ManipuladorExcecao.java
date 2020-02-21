package br.com.nwaa.controlecondominio.excecao;

import br.com.nwaa.controlecondominio.util.MetodosUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ManipuladorExcecao extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ServicoNaoDisponivelExcecao.class)
	public ResponseEntity<?> lancarException(ServicoNaoDisponivelExcecao ex, WebRequest webRequest) {
		return handleExceptionInternal(ex, "Serviço não disponível!", new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
	}

	@ExceptionHandler(DadoNaoEncontradoExcecao.class)
	public ResponseEntity<?> dadoNaoEncontradoExcecao(DadoNaoEncontradoExcecao ex, WebRequest webRequest) {
		return handleExceptionInternal(ex, "Dados não encontrado!", new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
	}

	@ExceptionHandler(DadoNaoCadastradoExcecao.class)
	public ResponseEntity<?> dadoNaoCadastradoExcecao(DadoNaoCadastradoExcecao ex, WebRequest webRequest) {
		return handleExceptionInternal(ex, "Dados não Cadastrado!", new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers,
																  HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", MetodosUtil.getDateTime());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);

	}
}
