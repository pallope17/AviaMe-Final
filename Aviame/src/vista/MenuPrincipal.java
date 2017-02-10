package vista;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.html.ImageView;



public class MenuPrincipal extends JFrame implements ActionListener {
		private JPanel panel;
		private JButton accionesPajaros, verEnfermedadesSintomas, 
		verMedicamentosAdministracion, ponerEnfermedadSintomas, 
		ponerMedicamentoAdministracion;
		private ImageView imagenLogo;
		private JLabel imagenLabel;
		private JMenuBar barra;
		private JMenu ayuda;
		private  JMenuItem salir, cerrarSesion,verAyuda,reportes;
		
		public MenuPrincipal() {
			iniciarGUI();
		}
		
		public void iniciarGUI(){
			
				panel= new JPanel();
				panel.setLayout(null);
				
				
				//PONER MENU
				
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
				
				
				accionesPajaros= new JButton("Registar/Eliminar/Modificar Pajaro");
				accionesPajaros.addActionListener(this);
				verEnfermedadesSintomas =  new JButton("Ver Enfermedades y Sintomas");
				verEnfermedadesSintomas.addActionListener(this);
				verMedicamentosAdministracion = new JButton("Ver Medicamentos y Administracion");
				verMedicamentosAdministracion.addActionListener(this);
				ponerEnfermedadSintomas = new JButton("Poner Enfermedades y Sintomas");
				ponerEnfermedadSintomas.addActionListener(this);
				ponerMedicamentoAdministracion = new JButton("Poner Medicamentos y Administracion");
				ponerMedicamentoAdministracion.addActionListener(this);
		
				//PONER IMAGEN
				
				imagenLabel = new JLabel();
				imagenLabel.setBounds(80, 20, 300, 240);
				
				 ImageIcon imagen= new  ImageIcon(getClass().getResource("/imagenes/usuario.jpg"));
			        Icon iconImagen = new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
			        imagenLabel.setIcon(iconImagen);
			        add(imagenLabel);
				
				
				
				accionesPajaros.setBounds(100,270,260,40);
				verEnfermedadesSintomas.setBounds(100,320,260,40);
				verMedicamentosAdministracion.setBounds(100,370,260,40);
				ponerEnfermedadSintomas.setBounds(100,420,260,40);
				ponerMedicamentoAdministracion.setBounds(100,470,260,40);
				
				
				//AÑADIR AL PANEL
				panel.add(imagenLabel);
				panel.add(accionesPajaros);
				panel.add(verEnfermedadesSintomas);
				panel.add(verMedicamentosAdministracion);
				panel.add(ponerEnfermedadSintomas);
				panel.add(ponerMedicamentoAdministracion);
				
				//AÑADIR PANEL
				add(panel);
				
				//PROPIEDADES PANEL
				setSize(460,580);
				setVisible(true);
				setResizable(false);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setLocationRelativeTo(null);
				setTitle("Bienvenido a Aviame");
	
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
			if(e.getSource()==accionesPajaros){
				RegistrarModificarEliminarPajaro r1= new RegistrarModificarEliminarPajaro();
				setVisible(false);
			}else if(e.getSource()==salir){
				
				System.exit(0);
				
			}else if(e.getSource()==cerrarSesion){
				int i=JOptionPane.showConfirmDialog(this,"Estas seguro de que quieres cerrar session");
				
				if(i==JOptionPane.OK_OPTION){
					Login l1=new Login();
					setVisible(false);
			}
			}
		}


	
	
		
		}
