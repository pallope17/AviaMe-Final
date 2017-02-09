package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ActualizaPajaro extends JFrame implements TableModelListener , MouseListener, ActionListener{
	
	private ModeloTablaActualizar miModelo;
	private JTable tablaPajaros;
	private JMenuBar barra;
	private JPanel panelTop;
	private JMenu ayuda;
	private  JMenuItem salir, cerrarSesion,verAyuda,reportes;
	private JTextField especieEdit,sexoEdit,colorEdit, observacionesEdit,idUsuarioEdit,idParejaEdit;
	private JLabel especie,sexo,color,observaciones,id_usuario,id_pareja, imagenLabel;
	JButton botonNuevoPajaro,atras;
	
	
	 public ActualizaPajaro() {
		iniciarGUI();
	}
	
	public void iniciarGUI(){
		
		
		 
		
		try {
			panelTop= new JPanel();
			add(panelTop, BorderLayout.PAGE_START);
			
			panelTop.setLayout(new GridLayout(6, 2));
			 especie = new JLabel("Especie :");
			 especieEdit= new JTextField();
			 
			 
			 sexo= new JLabel("Sexo :");
			 sexoEdit= new JTextField();
			 
			 color	= new JLabel("Color :");
			 colorEdit= new JTextField();
		
			 observaciones= new JLabel("Observaciones :");
			 observacionesEdit= new JTextField();
			 
			 id_usuario= new JLabel("ID Usuario :");
			 idUsuarioEdit= new JTextField();
			 
			 id_pareja=new JLabel("ID Pareja :");
			 idParejaEdit=new  JTextField();
			 
			 atras= new JButton("ATRAS");
			  
			  botonNuevoPajaro= new JButton("ACTUALIZAR PAJARO");
			 
			
				
			  panelTop.add(especie);
			  panelTop.add(especieEdit);
			
			  panelTop.add(sexo);
			  panelTop.add(sexoEdit);
			
			  panelTop.add(color);
			  panelTop.add(colorEdit);
			
			  panelTop.add(observaciones);
			  panelTop.add(observacionesEdit);
			
			  panelTop.add(id_usuario);
			  panelTop.add(idUsuarioEdit);
			
			  panelTop.add(id_pareja);
			  panelTop.add(idParejaEdit);
			
			
			  panelTop.add(atras);
			  panelTop.add(botonNuevoPajaro);
			
			  atras.addActionListener(this);
			  botonNuevoPajaro.addActionListener(this);
			
			barra= new JMenuBar();
			
			 ayuda= new JMenu("CUENTA");
			
			 salir= new JMenuItem("Salir");
			 cerrarSesion= new JMenuItem("Cerrar Sesion");
			 verAyuda= new JMenuItem("Ver Ayuda");
			 reportes= new JMenuItem("Hacer un Reporte");
			
			 salir.addActionListener(this);
			 cerrarSesion.addActionListener(this);
			 verAyuda.addActionListener(this);
			 reportes.addActionListener(this);
			
			ayuda.add(cerrarSesion);
			ayuda.add(reportes);
			ayuda.add(verAyuda);
			ayuda.add(salir);
			
			barra.add(ayuda);
			setJMenuBar(barra);
			miModelo= new ModeloTablaActualizar();
			tablaPajaros= new JTable(miModelo);
			
			tablaPajaros.getModel().addTableModelListener(this);
			
			tablaPajaros.addMouseListener(this);
			tablaPajaros.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tablaPajaros.setPreferredScrollableViewportSize(new Dimension(500, 100));
			JScrollPane scroll = new JScrollPane(tablaPajaros);
			
			add(scroll, BorderLayout.CENTER);
			
			
			pack();
			setSize(600,480);
			setLocationRelativeTo(null);
		
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==salir){
		System.exit(0);
		}else if(e.getSource()==cerrarSesion){
			int i=JOptionPane.showConfirmDialog(this,"Estas seguro de que quieres cerrar session");
			
			if(i==JOptionPane.OK_OPTION){
				Login l1=new Login();
				setVisible(false);
				
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
