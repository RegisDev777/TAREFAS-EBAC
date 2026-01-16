package br.com.rpires.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produto-service", url = "http://localhost:8082")
public interface ProdutoClient {
     
	 @GetMapping("/produtos/{id}")
	 ProdutoResponse buscarPorId(@PathVariable Long id);
	
}    
