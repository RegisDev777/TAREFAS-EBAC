package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class appJava {
    public static void main(String[] args) {
  	  String url = "jdbc:postgresql://localhost:5432/VendasOnlineEbac";
		  String usuario = "postgres";
	      String senha = "46412559";
		  
		  	try(Connection conexao = DriverManager.getConnection(url,usuario,senha)){
		  		System.out.println("Conexao realizada com sucesso!");
		  	} catch (SQLException e) {
		  		System.out.println("Erro ao conecta:" + e.getMessage());
		  	}
	}
}
