package br.com.rpires.SpringBootPrimeiroExemplo;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBancoDeDados {

	@Bean
	CommandLineRunner testarConexao(DataSource datasources ) {
		return args -> {
			try(Connection conn = datasources.getConnection()) {
				  System.out.println("✅ CONEXÃO COM O BANCO REALIZADA COM SUCESSO!");
	                System.out.println("Banco: " + conn.getMetaData().getDatabaseProductName());
			}
		};
	}
	
	 
	
}
