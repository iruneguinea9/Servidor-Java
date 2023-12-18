/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.tomcat.dbcp.dbcp2.PoolingConnection;
import org.apache.tomcat.dbcp.pool2.KeyedObjectPool;
import org.apache.tomcat.dbcp.pool2.impl.GenericKeyedObjectPool;
import org.apache.tomcat.dbcp.pool2.impl.GenericKeyedObjectPoolConfig;



public class PoolConex {    
    private static PoolingConnection poolingConnection;
    
    	static Connection connection = null;
	static {
		createPoolingConnection();
	}
	 
    
 
    private static void createPoolingConnection()            {
 
    	System.out.println("CREANDO POOOOOOOOOOOOOOOOOOOOOOOOOLLLLLLLLLLLLLLLLLLLLLL!L!!!!!!!!!!!!!!!!!!");
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/territorio","root","");

        poolingConnection = new PoolingConnection(connection);
 
        GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
        config.setMaxTotalPerKey(-1);
        config.setBlockWhenExhausted(false);
        config.setMaxWaitMillis(0);
        config.setMaxIdlePerKey(1);
        config.setMaxTotal(10);
 
        KeyedObjectPool stmtPool = new GenericKeyedObjectPool(
                poolingConnection, config);
 
        poolingConnection.setStatementPool(stmtPool);
        
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    
    public static String selectQuery() throws SQLException {
        PreparedStatement statement = null;
       String str=
                "********************Seleccion provincias************";
        
 
        try {
            statement = poolingConnection
                    .prepareStatement("SELECT * FROM provincias");
            ResultSet rs = statement.executeQuery();
 
            while (rs.next()) {
                str+= rs.getString("id_provincia")+" "+ rs.getString("provincia");
                        
               
            }
            System.out.println("");
            System.out
                    .println("*******************************************************");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
            return str;
        }
    }
	
	
    
}
