package com.ebacRelacoes.entidade;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ebacRelacoes.enuns.MarcaEnuns;

@Entity
@Table (name = "marca")
public class Marca {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column( name = "marca_empresa", nullable =  false, length = 30)
	private MarcaEnuns marca;
    
	@OneToMany(mappedBy = "marca",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Carro> carros = new HashSet<Carro>();
	
			
		    public Marca() {
				// TODO Auto-generated constructor stub
			}
             
		       public Long getId() {
						return id;
		       }
		                
			   public MarcaEnuns getMarca() {
				return marca;
			   }
			   public void setMarca(MarcaEnuns marca) {
				this.marca = marca;
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
						Marca other = (Marca) obj;
						return Objects.equals(id, other.id);
			   }
                    
                    
                     public void addCarro(Carro c) {
                    	 carros.add(c);
                     }
                     public void removeCarro(Carro c) {
                    	 carros.remove(c);
                     }
    
}
