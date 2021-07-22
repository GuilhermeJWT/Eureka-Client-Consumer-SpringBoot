package br.com.systemsgs.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.systemsgs.dto.ModelClienteConsumerDTO;

@FeignClient(name = "client-consumer", url = "localhost:8888/api/v1/clientes")
public interface ClienteConsumerClient {
	
	@PostMapping(value = "/salvar")
	String salvaCliente(ModelClienteConsumerDTO modelClienteConsumerDTO);
	
	@GetMapping(value = "/listaTodos")
	List<ModelClienteConsumerDTO> listaTodosClientes();
	
	@GetMapping(value = "/pesquisar/{id}")
	ModelClienteConsumerDTO pesquisaPorId(@PathVariable("id") Long id);
	
	@DeleteMapping(value = "/deletar/{id}")
	String deletaCliente(@PathVariable("id") Long id);
}
