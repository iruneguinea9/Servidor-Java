/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conn;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author dw2
 */
public class ConnPool {
    
    
    private static HikariDataSource dataSource;
	
	static {		
		HikariConfig config=new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/bdbiblio?useSSL=false");
		config.setUsername("root");
		config.setPassword("");
		
		config.addDataSourceProperty("minimumIdle", "5");
		config.addDataSourceProperty("maximumPoolSize", "25");
		
		dataSource=new HikariDataSource(config);
	}	
	
	public static Connection dameConexion() throws SQLException {
		return dataSource.getConnection();		
	}
    
}
