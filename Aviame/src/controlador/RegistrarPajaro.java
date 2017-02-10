package controlador;

import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.Session;

import models.Pajaro;
import models.Usuario;

public class RegistrarPajaro {
	
	public static Pajaro pajaro;

	public static boolean Registrarse(String especie, String sexo,String color,String observaciones, String idUsuario, String idPareja) throws SQLException {
		
		boolean resultado = false;
		Session session=ConectarseBaseDatos.conectar();
		
		pajaro = new Pajaro();
		pajaro.setEspecie(especie);
		pajaro.setSexo(sexo);
		pajaro.setColor(color);
		pajaro.setObservaciones(observaciones);
		
		int parejaNum=Integer.parseInt(idPareja);
		int usuario=Integer.parseInt(idUsuario);
		
		Pajaro pareja=(Pajaro)session.get(Pajaro.class, parejaNum);
		
		Usuario user=(Usuario)session.get(Usuario.class, usuario);
		
		boolean hacerRegistro=RegistrarPajaro.comprarRegistroPajaro( usuario, parejaNum);
		
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
	
	public static boolean comprarRegistroPajaro( int usuario , int pareja) throws SQLException{
		
		Session session=controlador.ConectarseBaseDatos.conectar();
		
		boolean registro=false;
		
		
	
	
		Iterator iter1= (Iterator)session.createQuery("From Pajaro where id_pajaro = '"+pareja+"'").iterate();
		Iterator iter2= (Iterator)session.createQuery("From Usuario where id_usuario = '"+usuario+"'").iterate();
		
		if(iter1.hasNext() && iter2.hasNext() ){
			registro=true;
			System.out.println("el usuario yaexiste");
		}else{registro=false;}
		
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
