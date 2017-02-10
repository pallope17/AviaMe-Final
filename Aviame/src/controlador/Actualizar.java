package controlador;

import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.Session;

import models.Pajaro;
import models.Usuario;


public class Actualizar {

	public static String [][] mostrarPajaros() throws SQLException{
		
		
		
		Session session= ConectarseBaseDatos.conectar();
		
		Iterator iter=(Iterator) session.createQuery("FROM Pajaro").iterate();
		int contadorCount=0;
		int contadorI=0;
		
		while(iter.hasNext()){
			
			Pajaro paj= (Pajaro)iter.next();
		contadorCount++;
		
		
		}
		
		String [][] pajaros = new String[contadorCount][7];
	
		Iterator iterator=(Iterator) session.createQuery("FROM Pajaro order by id_pajaro").iterate();
		while(iterator.hasNext() && contadorI<=contadorCount){
			Pajaro paj=(Pajaro)iterator.next();
			// for para recorrer los atributos

			for(int j=0;j<7;j++){
	
				
	
		if(j==0){pajaros[contadorI][j]=paj.getColor();
		}
		if(j==1){pajaros[contadorI][j]=paj.getEspecie();
		}
		if(j==2){pajaros[contadorI][j]=paj.getSexo();
		}
		if(j==3){pajaros[contadorI][j]=paj.getObservaciones();
		}
		
		if(paj.getPajaro()!=null){
		if(j==4){pajaros[contadorI][j]=paj.getPajaro().getIdPajaro().toString();
		}
		}else{
			pajaros[contadorI][j]="0";
		}
		
		if(j==5){pajaros[contadorI][j]=paj.getUsuario().getIdUsuario().toString();}
		if(j==6){pajaros[contadorI][j]=paj.getIdPajaro().toString();}
			}
			contadorI++;
		}
		
		
		return pajaros;}

	public static boolean introducirActualizacion(String color,String especie, String sexo, String observacion, String id_pareja, String id_usuario,String id_pajaro) throws SQLException{
		
		Session session=controlador.ConectarseBaseDatos.conectar();
		
		boolean resultado=false;
		
		int pajaro_id=Integer.valueOf(id_pajaro);
		Pajaro paj= (Pajaro)session.get(Pajaro.class, pajaro_id);
		
		paj.setColor(color);
		paj.setEspecie(especie);
		paj.setObservaciones(observacion);
		paj.setSexo(sexo);
		
		int pareja_id=Integer.valueOf(id_pareja);
		int usuario_id=Integer.valueOf(id_usuario);
		
		Pajaro pareja=(Pajaro)session.get(Pajaro.class, pareja_id);
		
		Usuario user=(Usuario)session.get(Usuario.class, usuario_id);
		
		boolean hacerRegistro=Actualizar.comprobarActualizacionPajaro( pareja, user);
		
		if(hacerRegistro==true){
			resultado=true;
			paj.setPajaro(pareja);
			paj.setUsuario(user);
			session.persist(paj);
			session.beginTransaction().commit();
			session.close();
		}else{
			resultado= false;
		}
		
		
	
		
		return resultado;
	}
	
	
	public static boolean comprobarActualizacionPajaro( Pajaro pareja, Usuario user) throws SQLException{
		
		Session session=controlador.ConectarseBaseDatos.conectar();
		
		boolean registro=false;
		
		
		if(user!=null && pareja ==null){registro=true;}else {registro=false;}
		
		return registro;
	
		
	}
}