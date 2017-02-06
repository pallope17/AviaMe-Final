package vista;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.VetoableChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

	public class RegistrarModificarEliminarPajaro extends JFrame implements ActionListener{
		private JPanel panel;
		private JButton registrarPajaro, modificarPajaro, 
			eliminarPajaro,atras;
		private JLabel imagenLabel;
		private JMenuBar barra;
		private JMenu ayuda;
		private  JMenuItem salir, cerrarSesion,verAyuda,reportes;
		
		public  RegistrarModificarEliminarPajaro(){
			iniciarGUI();
		}
		
		public void iniciarGUI(){
			
			
			/*-------------------------------------------------------------------------------------*/	
			barra= new JMenuBar();
			
			 ayuda= new JMenu("Ayuda");
			
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
		/*-------------------------------------------------------------------------------------*/	
			panel= new JPanel();
			panel.setLayout(null);
			registrarPajaro = new JButton("REGISTRAR PAJARO");
			registrarPajaro.addActionListener(this);
			modificarPajaro = new JButton("MODIFICAR PAJARO");
			modificarPajaro.addActionListener(this);
			eliminarPajaro = new JButton("ELIMINAR PAJARO");
			eliminarPajaro.addActionListener(this);
			atras=new JButton("VOLVER AL MENU PRINCIPAL");
			atras.addActionListener(this);
			//PONER IMAGEN
			imagenLabel = new JLabel();
			
			imagenLabel.setBounds(80, 20, 300, 240);
			
			
			//LLAMA AL METODO
			ponerImagen();
			registrarPajaro.setBounds(100,270,260,40);
			modificarPajaro.setBounds(100,320,260,40);
			eliminarPajaro.setBounds(100,370,260,40);
			atras.setBounds(100, 420,260,40);
			
	
			panel.add(imagenLabel);
			panel.add(registrarPajaro);
			panel.add(modificarPajaro);
			panel.add(eliminarPajaro);
			panel.add(atras);
			add(panel);
			//PROPIEDADES PANEL
			setSize(460,560);
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setTitle("Registar/Modificar/Eliminar Pajaro");
	}
	
	@Override
		public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
		
			if(e.getSource()==atras){
				MenuPrincipal m1= new MenuPrincipal();
					setVisible(false);
			}
			
			else if(e.getSource()==salir){
				System.exit(0);
			}else if(e.getSource()==cerrarSesion){
				Login l1= new Login();
				setVisible(false);
			}
		}
	
		public  void ponerImagen(){
			/*String rutaImagen="imagen1.jpg";
			URL url= getClass().getResource(rutaImagen);
			ImageIcon imagen= new  ImageIcon(url);*/
			
			ImageIcon imagen= new  ImageIcon("imagen1.jpg");
			Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
			imagenLabel.setIcon(icono);
			this.repaint();
			
		}
		
public void hacerBarraMenu(JMenuItem salir, JMenuItem cerrarSesion, JMenuItem verAyuda, JMenuItem reportes, JMenu ayuda, JMenuBar barra){
			
			barra= new JMenuBar();
			
			 ayuda= new JMenu("Ayuda");
			
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
			
		}
}
