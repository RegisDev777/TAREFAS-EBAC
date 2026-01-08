package br.com.rpires.SpringBootPrimeiroExemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.rpires.SpringBootPrimeiroExemplo.domain.Cliente;
import br.com.rpires.SpringBootPrimeiroExemplo.repository.IclienteRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringBootPrimeiroExemploApplication {
	
	private IclienteRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootPrimeiroExemploApplication.class);
	 

	 public static void main(String[] args) {
		SpringApplication.run(SpringBootPrimeiroExemploApplication.class, args);
	 }
	 
		
		  public void run(String... args) throws Exception {
		  log.info("StartApplication..."); Cliente cliente = createCliente();
		  repository.save(cliente); }
		  
		  private Cliente createCliente() { return Cliente.builder() .cidade("SP")
		  .cpf(12312312310L) .email("Teste@teste.com") .end("End") .estado("SP")
		  .nome("Teste Spring Boot") .numero(102030) .tel(10203040L) .build(); }
		

}
