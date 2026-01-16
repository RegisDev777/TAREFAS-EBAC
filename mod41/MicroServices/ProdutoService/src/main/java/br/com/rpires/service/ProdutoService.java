package br.com.rpires.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rpires.domain.Produto;
import br.com.rpires.dto.ProdutoRequestDTO;
import br.com.rpires.exception.ProdutoNaoEncontradoException;
import br.com.rpires.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	
	     public ProdutoService (ProdutoRepository produtoRepository) {
	    	 this.produtoRepository = produtoRepository;
	     }
	
	     
	     
	     public Produto cadastraProduto (ProdutoRequestDTO dto) {
	    	 Produto produto = new Produto();
	    	 produto.setNome(dto.getNome());
	    	 produto.setPreco(dto.getPreco());
	    	 produto.setQuantidade(dto.getQuantidade());
	    	 
	    	 produto.setAtivo(true);
	    			 
	    	 return produtoRepository.save(produto);
	    	
	     }
	     
	     public Produto buscarPorId(Long id) {
	         return produtoRepository.findById(id)
	                 .orElseThrow(ProdutoNaoEncontradoException::new);
	     }
	     
	     
	     public List<Produto> listaProdutos (){
             List<Produto> produtos = produtoRepository.findAll();
	    	 return produtos;
	     }
	     
	     
	     public Produto atualizar(Long id, ProdutoRequestDTO dto) {
	    	Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNaoEncontradoException::new);
		    	produto.setNome(dto.getNome());
		    	produto.setPreco(dto.getPreco());
	    	    produto.setQuantidade(dto.getQuantidade());
	         return produtoRepository.save(produto);
	     }
	     
	     
	     public void excluir (Long id) {
	    	 Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNaoEncontradoException::new);;
	    	 produto.setAtivo(false);
	    	 produtoRepository.save(produto);	    		    		    	 
	     }
	
	     
	     
	
}
