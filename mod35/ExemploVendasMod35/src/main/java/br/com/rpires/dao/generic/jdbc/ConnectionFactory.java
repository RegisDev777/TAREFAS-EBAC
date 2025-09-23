/**
 * 
 */
package br.com.rpires.dao.generic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author rodrigo.pires
 *
 */
public class ConnectionFactory {
	

    private static final String URL  = "jdbc:postgresql://localhost:5432/VendasOnlineEbac";
    private static final String USER = "postgres";
    private static final String PASS = "46412559";

    private ConnectionFactory() {}


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
	
}
