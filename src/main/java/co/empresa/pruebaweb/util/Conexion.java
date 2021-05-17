package co.empresa.pruebaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	
	private Connection con =null;
	private PreparedStatement preparedStatement;
	
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String dbName = "sistemag";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String userName = "root";
	private static final String password = "";
	private static Conexion db;
	
	
	public Conexion() {
		try {
			Class.forName(driver).newInstance();
			con = (Connection)DriverManager.getConnection(url+dbName,userName,password);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet query() throws SQLException{
       
        ResultSet res = preparedStatement.executeQuery();
        return res;
    }
	
	public int execute() throws SQLException {
        
        int result = preparedStatement.executeUpdate();
        return result;
 
    }
	public static Conexion getConexion(){
		if ( db == null ) {
            db = new Conexion();
        }
		return db;
	}
	public Connection getCon(){
		
		return con;
	}
	public PreparedStatement setpreparePreparedStatement(String sql)throws SQLException{
		
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
		
		
		
	}

}
