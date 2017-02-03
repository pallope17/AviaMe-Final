package controlador;

import java.util.Iterator;

import org.hibernate.classic.Session;

public class Login {
	
	
	public void registrase(){
		
	}
	
	
	
	
	public static boolean iniciarSesion(String username,String password){
		
		boolean exiten=false;
		
		Session session=(Session) ConectarseBaseDatos.conectar();
		
		System.out.println("************** antes de la consulta");
		
		Iterator iter=(Iterator) session.createQuery("from Usuario where username ='"+username+"' and contrasenya ='"+password+"' ").iterate();
		
		System.out.println("************** despues de la consulta");
		
		
		
		
		if(iter.hasNext()){
			System.out.println("************** dentro del iterator");
			exiten=true;
			
		}
		System.out.println("************** salgo del iterator");
		return exiten;
		
	}

}
