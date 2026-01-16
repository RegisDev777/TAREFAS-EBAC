package br.com.rpires.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rpires.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	
}
