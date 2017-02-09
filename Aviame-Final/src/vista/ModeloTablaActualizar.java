package vista;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import models.Pajaro;

public class ModeloTablaActualizar extends DefaultTableModel {
	
	Class tipos[] = {String.class,String.class,String.class,String.class,Integer.class,Integer.class};
	

	
	public ModeloTablaActualizar() throws SQLException{
		
		String [] columnas = {"COLOR","ESPECIE","SEXO","OBSERVACIONES","ID USUARIO","ID PAREJA"};
		
<<<<<<< HEAD:Aviame/src/vista/ModeloTablaActualizar.java
		String [][] filas = controlador.Actualizar.mostrarPajaros();
=======
		Object [][] filas = controlador.Actualizar.mostrarPajaros();
>>>>>>> dd319040b61bf515821afb2264af125f118e725f:Aviame-Final/src/vista/ModeloTablaActualizar.java
		
		
		setDataVector(filas,columnas);
	}
	
	
	public boolean isCellEditable(int i, int j){
		return false;
	}
	
	public Class<?> getColumnClass(int indice)
	{
		//System.out.println(indice);
		return tipos[indice];
	}

}
