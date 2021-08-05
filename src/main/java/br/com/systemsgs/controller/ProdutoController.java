package br.com.systemsgs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.client.ProdutoConsumerClient;
import br.com.systemsgs.dto.ModelProdutosConsumerDTO;
import feign.FeignException.FeignClientException;

@RestController
@RequestMapping(value = "/api/v1/consumer/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoConsumerClient produtoConsumerClient;
	
	@GetMapping(value = "/listaTodosProdutos")
	public List<ModelProdutosConsumerDTO> salvaProduto() {
		try {
			return produtoConsumerClient.listaTodosProdutos();
		}catch(FeignClientException exception) {
			exception.printStackTrace();
			return new ArrayList<ModelProdutosConsumerDTO>();
		}
	}
	
	@GetMapping(value = "/pesquisaPorId/{id}")
	public ModelProdutosConsumerDTO pesquisaProdutoPorId(@PathVariable("id") Long id){
		ModelProdutosConsumerDTO produtoPesquisado = produtoConsumerClient.pesquisaProdutoPorId(id);
		
		return produtoPesquisado;
	}
	
	@DeleteMapping(value = "/deletarProduto/{id}")
	public String deletaProduto(@PathVariable("id") Long id) {
		produtoConsumerClient.deletarProduto(id);
		
		return "Produto Deletado com Sucesso!!!";
	}
	
}
