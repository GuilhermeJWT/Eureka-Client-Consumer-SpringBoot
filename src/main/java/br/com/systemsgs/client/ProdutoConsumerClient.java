package br.com.systemsgs.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.systemsgs.dto.ModelProdutosConsumerDTO;

@FeignClient(name = "produto-consumer", url = "localhost:8888/api/v1/produtos")
public interface ProdutoConsumerClient {
	
	@GetMapping(value = "/listaTodos")
	List<ModelProdutosConsumerDTO> listaTodosProdutos();
	
	@GetMapping(value = "/pesquisar/{id}")
	ModelProdutosConsumerDTO pesquisaProdutoPorId(@PathVariable("id") Long id);
	
	@DeleteMapping(value = "/deletar/{id}")
	String deletarProduto(@PathVariable("id") Long id);

}
