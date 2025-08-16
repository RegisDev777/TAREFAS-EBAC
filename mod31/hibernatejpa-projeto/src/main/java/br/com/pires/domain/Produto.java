package br.com.pires.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO2")
public class Produto {
   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
	@SequenceGenerator(name = "produto_seq", sequenceName = "sq_produto", initialValue = 1, allocationSize = 1)
	  private Long id;
	
	@Column(name = "NOME", length = 100, nullable = false, unique = false)
	  private String nome;
	
	@Column(name = "descricao", length = 100, nullable = false, unique = false)  
	  private String descricao;	  
	
	@Column(name = "PRECO", length = 12 , nullable = false, unique = false)
	  private Double preco;

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
	
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
	
		public Double getPreco() {
			return preco;
		}
		public void setPreco(Double preco) {
			this.preco = preco;
		}
		  
	        
	
	
}
