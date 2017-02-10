package controlador;

import java.sql.SQLException;

import org.hibernate.Session;

import models.Enfermedad;
import models.Pajaro;
import models.Usuario;

public class RegistrarEnfermedad {

	public static Enfermedad enfermedad;

	public static boolean Enfermedad(String nombre, String sintomas) throws SQLException {
		
		boolean resultado = false;
		Session session=ConectarseBaseDatos.conectar();
		
		enfermedad = new Enfermedad();
		enfermedad.setNombre(nombre);
		enfermedad.setSintomas(sintomas);
	

		
			resultado=true;
			session.persist(enfermedad);
			session.beginTransaction().commit();
			session.close();
	
		resultado=true;
		
		
	
		

	return resultado;
		
}

}
