package controlador;

import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.Session;

import models.Usuario;

public class Registrarse {
	
	public static Usuario user;

	public static boolean  Registrarse(String nombre, String apellidos,String correo,String telefono, int edad, String username,
			String contrasenya) throws SQLException {
		
		boolean resultado=false;
		
		Session session=ConectarseBaseDatos.conectar();
		System.out.println("se insertan los datos");
		user= new Usuario();
		user.setNombre(nombre);
		user.setApellidos(apellidos);
		user.setCorreo(correo);
		user.setEdad(edad);
		user.setContrasenya(contrasenya);
		user.setUsername(username);
		user.setTelefono(telefono);
		
		System.out.println("antes de comprobar");
		boolean hacerRegistro=Registrarse.comprobarRegistro(username);
		System.out.println("despues de comprobar");
		
		if(hacerRegistro==true){
		
			resultado=true;
			session.persist(user);
			session.beginTransaction().commit();
			session.close();
		}else{
			
			resultado= false;
		}
		
		

	return resultado;
		
	}
	
	public static boolean comprobarRegistro(String username) throws SQLException {
		
		
		boolean registro = false;
		Session session = ConectarseBaseDatos.conectar();
		
			Iterator iter=(Iterator) session.createQuery("from Usuario where username like '"+username+"'").iterate();
	
			if(iter.hasNext()){
				System.out.println(username);
				registro=false;
				System.out.println("el usuario yaexiste");
			}else{registro=true;}
			
			 return registro;
	
	}
}
