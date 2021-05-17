package co.empresa.pruebaweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.pruebaweb.modelo.Usuario;
import co.empresa.pruebaweb.util.Conexion;
import java.sql.SQLException;

public class UsuarioDao {

	private Conexion conexion;

	
	private final static String INSERT_USUARIO_SQL = "INSERT INTO USUARIO (nombre,email,pais) VALUES (?,?,?);";
	private final static String DELETE_USUARIO_SQL = "DELETE FROM USUARIO WHERE id=? ;";
	private final static String UPDATE_USUARIO_SQL = "UPDATE USUARIO SET nombre=?,email=?,pais=? WHERE id=?;";
	private final static String SELECT_USUARIO_BY_ID = "SELECT * FROM USUARIO WHERE id= ?;";
	private final static String SELECT_ALL_USUARIO = "SELECT * FROM USUARIO;";
	public UsuarioDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public void insert(Usuario usuario) throws SQLException {
		
		try {
			PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(INSERT_USUARIO_SQL);
			prepareStatement.setString(1, usuario.getNombre());
			prepareStatement.setString(2, usuario.getEmail());
			prepareStatement.setString(3, usuario.getPais());
			
			conexion.execute();
			
		}catch(SQLException e) {
			
		}
	}
	
	public void delete(int id) throws SQLException {
		
		try {
			PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(DELETE_USUARIO_SQL);
			prepareStatement.setInt(1, id);
			
			
			conexion.execute();
			
		}catch(SQLException e) {
			
		}
		
	}
	public void update(Usuario usuario) throws SQLException {
		
		try {
			PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(UPDATE_USUARIO_SQL);
			prepareStatement.setString(1, usuario.getNombre());
			prepareStatement.setString(2, usuario.getEmail());
			prepareStatement.setString(3, usuario.getPais());
			prepareStatement.setInt(4, usuario.getId());
			
			
			conexion.execute();
			
		}catch(SQLException e) {
			
		}
		
	}
	
	public List<Usuario>selecAll(){
		
		List<Usuario>usuarios = new ArrayList<>();
		
		try {
			PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(SELECT_ALL_USUARIO);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuarios.add(new Usuario(id,nombre,email,pais));
				
			}
			
		} catch (SQLException e) {
			
		}
		
		
		return usuarios;
	}
	public Usuario selec(int id) {
		
		Usuario usuario = null;
		
		try {
			PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(SELECT_USUARIO_BY_ID);
			prepareStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuario = new Usuario(id,nombre,email,pais);
				
			}
			
		} catch (SQLException e) {
			
		}
		
		
		return usuario;
	}
	
	
	
	
}
