package models;
// Generated 07-feb-2017 12:59:42 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private Integer idUsuario;
	private String nombre;
	private String apellidos;
	private Integer edad;
	private String telefono;
	private String correo;
	private String username;
	private String contrasenya;
	private Set pajaros = new HashSet(0);

	public Usuario() {
	}

	public Usuario(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public Usuario(String nombre, String apellidos, Integer edad, String telefono, String correo, String username,
			String contrasenya, Set pajaros) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.username = username;
		this.contrasenya = contrasenya;
		this.pajaros = pajaros;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasenya() {
		return this.contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public Set getPajaros() {
		return this.pajaros;
	}

	public void setPajaros(Set pajaros) {
		this.pajaros = pajaros;
	}

}