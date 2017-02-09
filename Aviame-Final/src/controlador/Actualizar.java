package controlador;

import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.Session;

import models.Pajaro;


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
		
		String [][] pajaros = new String[contadorCount][6];
	
		Iterator iterator=(Iterator) session.createQuery("FROM Pajaro order by id_pajaro").iterate();
		while(iterator.hasNext() && contadorI<=contadorCount){
			Pajaro paj=(Pajaro)iterator.next();
			// for para recorrer los atributos

			for(int j=0;j<6;j++){
	
	
		if(j==0){pajaros[contadorI][j]=paj.getColor();}
		if(j==1){pajaros[contadorI][j]=paj.getEspecie();}
		if(j==2){pajaros[contadorI][j]=paj.getSexo();}
		if(j==3){pajaros[contadorI][j]=paj.getObservaciones();}
		
		if(paj.getPajaro()!=null){
		if(j==4){pajaros[contadorI][j]=paj.getPajaro().getIdPajaro().toString();}
		}else{
			pajaros[contadorI][j]="0";
		}
		
		if(j==5){pajaros[contadorI][j]=paj.getUsuario().getIdUsuario().toString();}
			}
			contadorI++;
		}
		
		return pajaros;}
}
