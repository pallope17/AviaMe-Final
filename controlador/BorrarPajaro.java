package controlador;

import java.sql.SQLException;

import org.hibernate.Session;

import models.Pajaro;
import models.Usuario;

public class BorrarPajaro {
	
public static boolean introducirBorrado(String id_pajaro) throws SQLException{
		
		Session session=controlador.ConectarseBaseDatos.conectar();
		
		boolean resultado=false;
		
		int pajaro_id=Integer.valueOf(id_pajaro);
		Pajaro paj= (Pajaro)session.get(Pajaro.class, pajaro_id);
		
	

		
		boolean hacerRegistro=BorrarPajaro.comprobarBorrado(paj);
		System.out.println(paj.getIdPajaro());
		
		if(hacerRegistro==true){
			System.out.println("valor true");
			resultado=true;
			session.delete(paj);
	
			session.beginTransaction().commit();
			session.close();
		}else{
			System.out.println("valor false");
			resultado= false;
		}
		
		
	
		
		return resultado;
	}
	
	
	public static boolean comprobarBorrado(Pajaro paj) throws SQLException{
		
		Session session=controlador.ConectarseBaseDatos.conectar();
		
		boolean registro=false;
		
		System.out.println(paj.getIdPajaro());
		if( paj !=null){
			registro=true;
		System.out.println("que pasa +++++++++++++++++++++++++++++++");}else {registro=false;}
		
		return registro;
	
		
	}
}
