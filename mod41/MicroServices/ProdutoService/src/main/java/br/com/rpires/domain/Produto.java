package br.com.rpires.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "produto")
public class Produto {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private BigDecimal preco;
	
	@Column
	private Integer quantidade;
	
	@Column(name = "ativo", nullable = false)
	private Boolean ativo  = true;
	 
	    
	         public Produto() {
				// TODO Auto-generated constructor stub
			  }

    

			 public Produto(Long id, String nome, BigDecimal preco, Integer quantidade, Boolean ativo) {
				this.id = id;
				this.nome = nome;
				this.preco = preco;
				this.quantidade = quantidade;
				this.ativo = ativo;
			}






			 public Long getId() {
				 return id;
			 }
			 public void setId(Long id) {
				 this.id = id;
			 }


			 public String getNome() {
				 return nome;
			 }
			 public void setNome(String nome) {
				 this.nome = nome;
			 }


			 public BigDecimal getPreco() {
				 return preco;
			 }
			 public void setPreco(BigDecimal preco) {
				 this.preco = preco;
			 }


			 public Integer getQuantidade() {
				 return quantidade;
			 }
			 public void setQuantidade(Integer quantidade) {
				 this.quantidade = quantidade;
			 }


			 public Boolean getAtivo() {
				 return ativo;
			 }
			 public void setAtivo(Boolean ativo) {
				 this.ativo = ativo;
			 }
	         
	
}
