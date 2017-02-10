package controlador;

import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.classic.Session;

public class Login {
	
	
	public void registrase(){
		
	}
	
	public static boolean iniciarSesion(String username,String password) throws SQLException{
		
		boolean exiten=false;
		
		Session session=(Session) ConectarseBaseDatos.conectar();
		
		Iterator iter=(Iterator) session.createQuery("from Usuario where username ='"+username+"' and contrasenya ='"+password+"' ").iterate();
		
		if(iter.hasNext()){
	
			exiten=true;
			
		}
	
		return exiten;
		
	}

}
