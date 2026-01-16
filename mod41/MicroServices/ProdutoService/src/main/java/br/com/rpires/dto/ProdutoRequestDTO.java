package br.com.rpires.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ProdutoRequestDTO {
	@NotBlank(message = "Nome do  Produto e obrigatorio")
	private String nome;
	
	
	@NotNull(message = "Preco e obrigatorio")
	@DecimalMin(value = "0.01", message = "Preco deve ser maior que zero")
	private BigDecimal preco;
	
	@NotNull(message = "Quantidade e obrigatoria")
	@PositiveOrZero(message = "Quantidade nao pode ser negativa" )
	private Integer quantidade;

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
}
