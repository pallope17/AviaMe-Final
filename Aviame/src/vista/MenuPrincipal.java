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
import javax.swing.JPanel;
import javax.swing.text.html.ImageView;



public class MenuPrincipal extends JFrame implements ActionListener {
		private JPanel panel;
		private JButton accionesPajaros, verEnfermedadesSintomas, 
		verMedicamentosAdministracion, ponerEnfermedadSintomas, 
		ponerMedicamentoAdministracion;
		private ImageView imagenLogo;
		private JLabel imagenLabel;
		
		
		public MenuPrincipal() {
			iniciarGUI();
		}
		
		public void iniciarGUI(){
				panel= new JPanel();
				panel.setLayout(null);
				accionesPajaros= new JButton("Registar/Elimiar/Modificar Pajaro");
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
				ponerImagen();
				
				
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
				setSize(460,560);
				setVisible(true);
				setResizable(false);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setLocationRelativeTo(null);
				setTitle("Bienvenido a Aviame");
	
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		}

		
		public void ponerImagen(){
			
			ImageIcon imagen= new ImageIcon("imagen1.jpg");
			Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
			imagenLabel.setIcon(icono);
			this.repaint();
			
		}
		
		}
