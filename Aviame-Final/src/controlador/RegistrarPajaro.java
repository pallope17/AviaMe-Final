package controlador;

import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.Session;

import models.Pajaro;
import models.Usuario;

public class RegistrarPajaro {
	
	public static Pajaro pajaro;

	public static boolean Registrarse(String especie, String sexo,String color,String observaciones, int idUsuario, int idPareja) throws SQLException {
		
		boolean resultado = false;
		Session session=ConectarseBaseDatos.conectar();
		
		pajaro = new Pajaro();
		pajaro.setEspecie(especie);
		pajaro.setSexo(sexo);
		pajaro.setColor(color);
		pajaro.setObservaciones(observaciones);
		
		Pajaro pareja=(Pajaro)session.get(Pajaro.class, idPareja);
		
		Usuario user=(Usuario)session.get(Usuario.class, idUsuario);
		
		boolean hacerRegistro=RegistrarPajaro.comprarRegistroPajaro(idUsuario, idPareja, pareja, user);
		
		if(hacerRegistro==true){
			resultado=true;
			pajaro.setPajaro(pareja);
			pajaro.setUsuario(user);
			session.persist(pajaro);
			session.beginTransaction().commit();
			session.close();
		}else{
			resultado= false;
		}
		
		
	
		

	return resultado;
		
	}
	
	public static boolean comprarRegistroPajaro(int id_username,int id_pareja, Pajaro pareja, Usuario user) throws SQLException{
		
		Session session=controlador.ConectarseBaseDatos.conectar();
		
		boolean registro=false;
		
		
		if(user!=null && pareja ==null){registro=true;}else {registro=false;}
		
		return registro;
	
		
	}
	
	
	
	
	public static boolean comprobarRegistro(String username) {
		
		
		boolean registro = false;
		Session session;
		try {
			session = ConectarseBaseDatos.conectar();
			Iterator iter=(Iterator) session.createQuery("from Usuario where username ='"+username+"'").iterate();
	
			
			while(iter.hasNext()){
				registro=false;
			}
			if(registro==false){
				
				
			}else{
				
				System.out.println("el pajaro no existe");
				registro=true;
				
				session.persist(pajaro);
				
				session.beginTransaction().commit();
				
				session.close();
				}


			return registro;
			
		} catch (SQLException e) {
			registro=false;
			return registro;
		}
			 
	
	}

}
