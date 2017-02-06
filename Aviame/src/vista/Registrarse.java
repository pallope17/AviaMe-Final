package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;



public class Registrarse extends JFrame implements TableModelListener , MouseListener, ActionListener{
	
	JTable tablaRegistrarse;
	JPanel panelBot;
	JTextField nombreEdit;
	JTextField edadEdit;
	JTextField equipoEdit;
	JTextField posicionEdit;
	JTextField lesionadoEdit;
	JButton botonNuevoJugador;
	ModeloTablaRegistrarse miModelo;
	
	public Registrarse() {
		super("Liga de Futbol");
		iniciarGUI();
	}
		
		
	public void iniciarGUI(){
		

		 miModelo= new ModeloTablaRegistrarse();
		 tablaRegistrarse= new JTable((TableModel) miModelo);
	

			 
			 tablaRegistrarse.getModel().addTableModelListener(this);
			 tablaRegistrarse.addMouseListener(this);
			 
			 tablaRegistrarse.setPreferredScrollableViewportSize(new Dimension(60,60));
			 JScrollPane panelScroll= new JScrollPane(tablaRegistrarse);
			add(panelScroll,BorderLayout.CENTER);
			
			panelBot= new JPanel(new GridLayout(6, 2));

			
			JLabel nombreEti= new JLabel("Nombre :");
			 nombreEdit= new JTextField();
			 
			JLabel edadEti= new JLabel("Edad :");
			 edadEdit= new JTextField();
			 
			JLabel equipoEti= new JLabel("Equipo :");
			 equipoEdit= new JTextField();
			 
			JLabel posicionEti= new JLabel("Posicion :");
			 posicionEdit= new JTextField();
			 
			JLabel lesionadoEti= new JLabel("Lesionado :");
			 lesionadoEdit= new JTextField();
			
			 JLabel enBlanco= new JLabel();
			 botonNuevoJugador= new JButton("Nuevo Jugador");
			 
			 
			panelBot.add(nombreEti);
			panelBot.add(nombreEdit);
			
			panelBot.add(edadEti);
			panelBot.add(edadEdit);
			
			panelBot.add(equipoEti);
			panelBot.add(equipoEdit);
			
			panelBot.add(posicionEti);
			panelBot.add(posicionEdit);
			
			panelBot.add(lesionadoEti);
			panelBot.add(lesionadoEdit);
			
			
			panelBot.add(enBlanco);
			panelBot.add(botonNuevoJugador);
			
			botonNuevoJugador.addActionListener(this);
			add(panelBot, BorderLayout.PAGE_END);
			
			pack();
			setSize(600,400);
			setLocationRelativeTo(null);
		
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

		


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Has pincha en "+e.getPoint());
		
		int filas=tablaRegistrarse.rowAtPoint(e.getPoint());
		
		int columnas= tablaRegistrarse.columnAtPoint(e.getPoint());
		
		System.out.println("Fila :"+filas+" Columna :"+columnas);
		
		if(filas>=0 && columnas >=0){
			System.out.println(tablaRegistrarse.getValueAt(filas, columnas));
		}
		boolean lesionado;
		
		
		
		 for(int i=0;i<tablaRegistrarse.getRowCount();i++){
			 
			 if(filas==tablaRegistrarse.rowAtPoint(e.getPoint())){
				 nombreEdit.setText((String) tablaRegistrarse.getValueAt(filas, 0));
				 edadEdit.setText((String) tablaRegistrarse.getValueAt(filas, 1));
				 equipoEdit.setText((String) tablaRegistrarse.getValueAt(filas, 2));
				 posicionEdit.setText((String) tablaRegistrarse.getValueAt(filas, 3));
				 
					if((Boolean)tablaRegistrarse.getValueAt(filas, 4)==true){
						lesionadoEdit.setText("Esta lesionado");
					}else{
						lesionadoEdit.setText("Puede Jugar");
					}
				
				 
				 
			 }
		 }
		
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Pincha la Tabla");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubx
		
		if(e.getSource()==botonNuevoJugador){
			
			String nombre= nombreEdit.getText();
			String edad= edadEdit.getText();
			String equipo=equipoEdit.getText();
			String posicion= posicionEdit.getText();
			boolean lesionado;
			
			if(lesionadoEdit.getText().equals("Si") || lesionadoEdit.getText().equals("SI")){
				lesionado=true;
				}else{
					lesionado=false;
				}
			miModelo.addRow(new Object [] {nombre,edad,equipo,posicion,lesionado});
			
		}
	}

}


