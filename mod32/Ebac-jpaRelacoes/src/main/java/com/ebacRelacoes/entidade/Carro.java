package com.ebacRelacoes.entidade;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
    private String modelo;
	
	private Integer ano;
   
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "marca_id", nullable = false)
	private Marca marca;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JoinTable(
	  name = "carro_acessorio",
	  joinColumns = @JoinColumn(name = "carro_id"),
	  inverseJoinColumns = @JoinColumn(name = "acessorio_id")
	)
	private Set<Acessorio> acessorios = new HashSet<Acessorio>();
	
	
	public Carro() {
		// TODO Auto-generated constructor stub
	 }

			public Long getId() {
			    return id;
			}

			public String getModelo() {
				return modelo;
			}
			public void setModelo(String modelo) {
				this.modelo = modelo;
			}
		
			public Integer getAno() {
				return ano;
			}
			public void setAno(Integer ano) {
				this.ano = ano;
			}
			 
		    public Marca getMarca() {
				return marca;
			}
		    public void setMarca(Marca marca) {
				this.marca = marca;
			}
		    
		    public Set<Acessorio> getAcessorios() {
				return acessorios;
			}

		
		    @Override
			public int hashCode() {
				return Objects.hash(id);
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Carro other = (Carro) obj;
				return Objects.equals(id, other.id);
			}
	    
		    
			public void addAcessorio(Acessorio a) {
				acessorios.add(a);
			}
			public void removeAcessorio(Acessorio a) {
				acessorios.add(a);
			}
	
}
