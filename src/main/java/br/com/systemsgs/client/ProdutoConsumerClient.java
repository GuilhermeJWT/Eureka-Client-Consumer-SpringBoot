package br.com.systemsgs.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.systemsgs.dto.ModelProdutosConsumerDTO;

@FeignClient(name = "produto-consumer", url = "localhost:8888/api/v1/produtos")
public interface ProdutoConsumerClient {
	
	@GetMapping(value = "/listaTodos")
	List<ModelProdutosConsumerDTO> listaTodosProdutos();

}
