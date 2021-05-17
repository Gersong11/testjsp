package co.empresa.pruebaweb.modelo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
public class Usuario implements Serializable {

	private Integer id;
	private String nombre;
	
	private String email;
	
	private String pais;

	

	public Usuario(Integer id, String nombre, String email, String pais) {
		
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pais = pais;
	}
	public Usuario( String nombre, String email, String pais) {
		
	
		this.nombre = nombre;
		this.email = email;
		this.pais = pais;
	}
	
	
	
	
	






}
