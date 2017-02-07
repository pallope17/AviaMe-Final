package controlador;

import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.Session;

import models.Pajaro;


public class Actualizar {

	public static String[][] mostrarPajaros() throws SQLException{
		
		String [][] pajaros = null;
		
		Session session= ConectarseBaseDatos.conectar();
		
		Iterator iter=(Iterator) session.createQuery("FROM Pajaro").iterate();
		
		int contadorI=0;
		
		while(iter.hasNext()){
			
			// for para recorrer los atributos
			for(int j=0;j<6;j++){
			Pajaro paj=(Pajaro)iter.next();
			
		if(j==0){pajaros[contadorI][j]=paj.getColor();}
		if(j==1){pajaros[contadorI][j]=paj.getEspecie();}
		if(j==2){pajaros[contadorI][j]=paj.getSexo();}
		if(j==3){pajaros[contadorI][j]=paj.getObservaciones();}
		if(j==4){pajaros[contadorI][j]=paj.getPajaro().getIdPajaro().toString();}
		if(j==5){pajaros[contadorI][j]=paj.getUsuario().getIdUsuario().toString();}
		
		if(j==5)
		contadorI++;
			}
		
		}
		
		return pajaros;}
}
