package controlador;

import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.Session;

import models.Usuario;

public class Registrarse {
	
	public static Usuario user;

	public static void Registrarse(String nombre, String apellidos,String correo,String telefono, int edad, String username,
			String contrasenya) throws SQLException {
		
		
		Session session=ConectarseBaseDatos.conectar();
		
		user= new Usuario();
		user.setNombre(nombre);
		user.setApellidos(apellidos);
		user.setCorreo(correo);
		user.setEdad(edad);
		user.setContrasenya(contrasenya);
		user.setUsername(username);
		user.setTelefono(telefono);

	
		
	}
	
	public static boolean comprobarRegistro(String username) throws SQLException{
		
		
		boolean registro;
		Session session=ConectarseBaseDatos.conectar();
			 
		Iterator iter=(Iterator) session.createQuery("from Usuario where username ='"+username+"'").iterate();
		
		if(iter.hasNext()){registro=false;}else{registro=true;}
		
		session.persist(user);
		
		session.beginTransaction().commit();
		
		session.close();
	
		
		
		return registro;
	}
}