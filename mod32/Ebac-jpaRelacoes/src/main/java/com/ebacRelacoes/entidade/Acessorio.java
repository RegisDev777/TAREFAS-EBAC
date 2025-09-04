package com.ebacRelacoes.entidade;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;import org.hibernate.type.TrueFalseType;

import com.ebacRelacoes.enuns.Modificacoes;


@Entity
@Table(name = "acessorio")
public class Acessorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column( name = "modificacao", nullable =  false, length = 30)
	private Modificacoes enumModificacoes;	
	
	@ManyToMany(mappedBy = "acessorios", fetch = FetchType.LAZY)
	private Set<Carro> carros = new HashSet<Carro>();
	
	
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public Modificacoes getEnumModificacoes() {
			return enumModificacoes;
		}
		public void setEnumModificacoes(Modificacoes enumModificacoes) {
			this.enumModificacoes = enumModificacoes;
		}
		
		public Set<Carro> getCarros() {
			return carros;
		}
		public void setCarros(Set<Carro> carros) {
			this.carros = carros;
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
			Acessorio other = (Acessorio) obj;
			return Objects.equals(id, other.id);
		}
	
		
	
}
