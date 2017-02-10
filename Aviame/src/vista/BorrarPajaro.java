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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import controlador.Actualizar;



public class BorrarPajaro extends JFrame implements TableModelListener , MouseListener, ActionListener{
	
	private JTable tablaPajaros;
	private JMenuBar barra;
	private JPanel panelBot, top;
	private JMenu ayuda;

	private  JMenuItem salir, cerrarSesion,verAyuda,reportes;
	private JLabel especieEdit,sexoEdit,colorEdit, observacionesEdit,idUsuarioEdit,idParejaEdit;

	private JLabel especie,sexo,color,observaciones,id_usuario,id_pareja, imagenLabel, idPajaro, id_pajaroIntro;

	JButton borrarPajaro,atras;
	private ModeloTablaActualizar miModelo;
	
	public BorrarPajaro(){
		iniciarGUI();
	}

	public void iniciarGUI(){
		
		try {
			miModelo= new ModeloTablaActualizar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tablaPajaros= new JTable(miModelo);
		
		tablaPajaros.getModel().addTableModelListener(this);
		
		tablaPajaros.addMouseListener(this);
		tablaPajaros.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaPajaros.setPreferredScrollableViewportSize(new Dimension(500, 100));
		JScrollPane scroll = new JScrollPane(tablaPajaros);
		
		add(scroll, BorderLayout.PAGE_END);
		
		panelBot= new JPanel();
		add(panelBot, BorderLayout.CENTER);
		
		panelBot.setLayout(new GridLayout(8, 2));
		especie = new JLabel("ESPECIE :");
		especieEdit= new JLabel();
		 
		 
		 sexo= new JLabel("SEXO :");
		 sexoEdit= new JLabel();
		 
		 color	= new JLabel("COLOR :");
		 colorEdit= new JLabel();
	
		 observaciones= new JLabel("OBSERVACIONES :");
		 observacionesEdit= new JLabel();
		 
		 id_usuario= new JLabel("ID USUARIO :");
		 idUsuarioEdit= new JLabel();
		 
		 id_pareja=new JLabel("ID PAREJA :");
		 idParejaEdit=new  JLabel();
		 
		 idPajaro= new JLabel("ID PAJARO");
		 id_pajaroIntro= new JLabel();
		 
		 
		 atras= new JButton("ATRAS");
		  
		  borrarPajaro= new JButton("BORRAR PAJARO");
		  
		  panelBot.add(especie);
		  panelBot.add(especieEdit);
		
		  panelBot.add(sexo);
		  panelBot.add(sexoEdit);
		
		  panelBot.add(color);
		  panelBot.add(colorEdit);
		
		  panelBot.add(observaciones);
		  panelBot.add(observacionesEdit);
		
		  panelBot.add(id_usuario);
		  panelBot.add(idUsuarioEdit);
		
		  panelBot.add(id_pareja);
		  panelBot.add(idParejaEdit);
		
		  panelBot.add(idPajaro);
		  panelBot.add(id_pajaroIntro);
		  
		  panelBot.add(atras);
		  panelBot.add(borrarPajaro);
		  
		
		
		  atras.addActionListener(this);
		  borrarPajaro.addActionListener(this);
		
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
		
		setResizable(false);
		
		pack();
		setSize(600,480);
		setLocationRelativeTo(null);
	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    

}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==salir){
			System.exit(0);
			}else if(e.getSource()==cerrarSesion){
				int i=JOptionPane.showConfirmDialog(this,"Estas seguro de que quieres cerrar session");
				
				if(i==JOptionPane.OK_OPTION){
					Login l1=new Login();
					setVisible(false);
					
				}
			}else if(e.getSource()==borrarPajaro){
				
				
				String idpajaro=id_pajaroIntro.getText();
				
			
				this.repaint();
				
					try {
						System.out.println("antes del metodo");
						boolean borrar=controlador.BorrarPajaro.introducirBorrado(id_pajaroIntro.getText());
						System.out.println("despues del metodo");
						if(borrar==true){
							setVisible(false);
							JOptionPane.showMessageDialog(this,"YA SE HA BORRADO EL PAJARO DE LA BASE DE DATOS");
							MenuPrincipal m1= new MenuPrincipal();
							
						}else{
							setVisible(false);
							JOptionPane.showMessageDialog(this,"NO SE HA PODIDO REALIZAR LA OPERACIÓN");
							setVisible(true);
						}
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}else if(e.getSource()==atras){
				RegistrarModificarEliminarPajaro m1= new RegistrarModificarEliminarPajaro();
				setVisible(false);
			}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
int filas=tablaPajaros.rowAtPoint(e.getPoint());
		
		int columnas= tablaPajaros.columnAtPoint(e.getPoint());
		
 for(int i=0;i<tablaPajaros.getRowCount();i++){
			 
			 if(filas==tablaPajaros.rowAtPoint(e.getPoint())){
				 colorEdit	.setText((String) tablaPajaros.getValueAt(filas, 0));
				 especieEdit.setText((String) tablaPajaros.getValueAt(filas, 1));
				 sexoEdit.setText((String) tablaPajaros.getValueAt(filas, 2));
				 observacionesEdit.setText((String) tablaPajaros.getValueAt(filas, 3));
				 idUsuarioEdit.setText((String)tablaPajaros.getValueAt(filas, 4));
				 idParejaEdit.setText((String)tablaPajaros.getValueAt(filas, 5));
				 id_pajaroIntro.setText((String)tablaPajaros.getValueAt(filas, 6));
				 
					
				
				 
				 
			 }
		 }
		
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
