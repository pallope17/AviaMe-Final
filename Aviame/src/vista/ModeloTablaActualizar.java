package vista;

import javax.swing.table.DefaultTableModel;

import models.Pajaro;

public class ModeloTablaActualizar extends DefaultTableModel {
	
	Class tipos[] = {String.class,String.class,String.class,String.class,Integer.class,Integer.class};
	

	
	public ModeloTablaActualizar(){
		
		String [] columnas = {"COLOR","ESPECIE","SEXO","OBSERVACIONES","ID USUARIO","ID PAREJA"};
		
		Pajaro [][] filas = null;
		
		
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
