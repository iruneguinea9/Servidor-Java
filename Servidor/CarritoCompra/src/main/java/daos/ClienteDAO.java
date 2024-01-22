package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Cliente;
import conn.ConnPool;

/**
 * @author Amaia
 *
 */
/**
 * @author Amaia
 *
 */
public class ClienteDAO {

	public ClienteDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Busca en la BD el cliente con el nombre de usuario y password recibidos como par�metros y lo
     * devuelve como Cliente (null si no existe)
	 * @param nombre
	 * @param password
	 * @return
	 */
	public ArrayList<Cliente> buscarClientes () {
		
		ArrayList<Cliente> arrClientes= new ArrayList<Cliente>();
		
		try {
			Connection con= ConnPool.dameConexion();
			String sql="SELECT * FROM CLIENTE";
			Statement st= con.createStatement();
	
			ResultSet rs= st.executeQuery(sql);
			
			
			while(rs.next()) {
				Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"),rs.getString("password"),rs.getString("domicilio"),rs.getString("codigopostal"),rs.getString("telefono"),rs.getString("email"));
			
				arrClientes.add(cliente);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrClientes;
		
	}

	/**
	 * Busca en la BD el cliente con el nombre de usuario y password recibidos como
	 * par�metros y lo devuelve como Cliente (null si no existe)
	 * 
	 * @param nombre
	 * @param password
	 * @return
	 */
	public Cliente buscaCliente(String nombre, String password) {
		return null;

	}

	/**
	 * que devuelve si existe o no un cliente con el nombre indicado.
	 * 
	 * @param nombre
	 * @return
	 */
	public boolean buscaCliente(String nombre) {

		boolean existe = false;
		try {
			Connection con = ConnPool.dameConexion();
			String sql = "SELECT * FROM CLIENTEs where NOMBRE=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nombre);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				existe = true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return existe;

	}

	/**
	 * Guarda un nuevo cliente en la BD, con la informaci�n del par�metro. Devuelve
	 * si la operaci�n ha tenido �xito (Debe utilizar consultas precompiladas)
	 * 
	 * @param c
	 * @return
	 */
	public boolean guardaCliente(Cliente c) {
		return false;

	}

	/**
	 * que actualiza el cliente de id contenido en c, con el resto de atributos
	 * contenidos en c (Debe utilizar consultas precompiladas)
	 * 
	 * @param c
	 * @return
	 */
	public boolean actualizaCliente(Cliente c) {
		return false;

	}

}
