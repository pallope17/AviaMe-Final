package controlador;

import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.Session;

import models.Pajaro;


public class Actualizar {

	public Pajaro[][] mostrarPajaros() throws SQLException{
		
		Pajaro [][] pajaros;
		
		Session session= ConectarseBaseDatos.conectar();
		
		Iterator iter=(Iterator) session.createQuery("FROM Pajaro").iterate();
		
		while(iter.hasNext()){
			Pajaro paj=(Pajaro)iter.next();
			
		}
		
		return null;}
}
