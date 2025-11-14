package br.com.hospitalcaldas.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import br.com.hospitalcaldas.typeEnum.SexoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;




@Entity					//garante cof unico no banco 
@Table(name = "paciente", uniqueConstraints = { @UniqueConstraint(name = "uk_paciente_cpf", columnNames = "cpf")})
        
public class Paciente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Postgres: usa identity/autoincrement
	private Long id;
	
	
	@NotBlank(message = "Nome e obrigatorio")
	@Column(nullable = false, length = 150)
	private String nome; //obrigatorio
	
	
	  /**
    * CPF:
     * - Aqui deixo um @Pattern simples (somente dígitos) para evitar caracteres inválidos.
     * - Se você armazenar com máscara (xxx.xxx.xxx-xx), troque o pattern ou remova-o.
     * - A unicidade real é garantida pela constraint no @Table.
     */	
	@NotBlank(message = "CPF e obrigatorio")
	@Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
	@Pattern(regexp = "^[0-9.\\-]{11,14}$", message = "CPF deve conter apenas dígitos e/ou máscara")
	@Column(nullable = false, length = 14)
	private String cpf; // unico, Obrigatorio, mascara, validacao
	
	
	private LocalDate dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private SexoEnum sexo;
	
	
	@Size(max = 20)
	private String telefone;
	
	
	@Size(max = 150)
	private String contatoEmergencia;
	
	
	@Column(nullable = false)
	private Boolean ativo = true; // valor default 

    @Column(nullable = false, updatable = false)
	private LocalDateTime criadoEm;
	
    @Column(nullable = false) 
    private LocalDateTime atualizadoEm;
	
    
    @OneToMany(mappedBy = "paciente")
    private List<Internacao> internacaoes;
    
    
    @PrePersist
    public void prePersist() {
    	this.criadoEm = LocalDateTime.now();
    	this.atualizadoEm = this.criadoEm;	
    			if(this.cpf != null)this.cpf = this.cpf.trim();	
    			if(this.nome != null)this.nome = this.nome.trim(); 					
    } 
    @PreUpdate
    public void preUpdate() {
    	this.atualizadoEm = LocalDateTime.now();
    	  if(this.cpf != null) this.cpf = this.cpf.trim();
    	  if(this.nome != null) this.nome = this.nome.trim();
    	  if(this.telefone != null) this.telefone = this.telefone.trim();
    	  if(this.contatoEmergencia != null) this.contatoEmergencia = this.contatoEmergencia.trim();
   
    }
    
    
    
    
    
    
    
	                public Paciente() {
						// TODO Auto-generated constructor stub
	                }
					
					
					public String getNome() {
						return nome;
					}
					public void setNome(String nome) {
						this.nome = nome;
					}
					
					
					public String getCpf() {
						return cpf;
					}
					public void setCpf(String cpf) {
						this.cpf = cpf;
					}
					
					
					public LocalDate getDataNascimento() {
						return dataNascimento;
					}
					public void setDataNascimento(LocalDate dataNascimento) {
						this.dataNascimento = dataNascimento;
					}
					
					
					public SexoEnum getSexo() {
						return sexo;
					}
					public void setSexo(SexoEnum sexo) {
						this.sexo = sexo;
					}
					
					
					public String getTelefone() {
						return telefone;
					}
					public void setTelefone(String telefone) {
						this.telefone = telefone;
					}
					
					
					public String getContatoEmergencia() {
						return contatoEmergencia;
					}
					public void setContatoEmergencia(String contatoEmergencia) {
						this.contatoEmergencia = contatoEmergencia;
					}
					
					
					public Boolean getAtivo() {
						return ativo;
					}
					public void setAtivo(Boolean ativo) {
						this.ativo = ativo;
					}
					
					
					public Long getId() {
						return id;
					}
					public void setId(Long id) {
						this.id = id;
					}
					
					public LocalDateTime getCriadoEm() {
						return criadoEm;
					}
					public void setCriadoEm(LocalDateTime criadoEm) {
						this.criadoEm = criadoEm;
					}
										
					public LocalDateTime getAtualizadoEm() {
						return atualizadoEm;
					}
					public void setAtualizadoEm(LocalDateTime atualizadoEm) {
						this.atualizadoEm = atualizadoEm;
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
									Paciente other = (Paciente) obj;
									return Objects.equals(id, other.id);
								}
	                  
					
					
								
	
	 
	
	
	 
}
