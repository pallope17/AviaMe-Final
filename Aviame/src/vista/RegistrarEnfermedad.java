package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
import javax.swing.JTextField;

public class RegistrarEnfermedad extends JFrame implements ActionListener{
	
	

	JPanel panelBot,panelImagen;
	JTextField nombreEdit, sintomasEdit;
	JLabel nombre,sintomas,imagenLabel;
	JButton botonNuevaEnfermedad,atras;
	private JMenuBar barra;
	private JMenu ayuda;
	private  JMenuItem salir, cerrarSesion,verAyuda,reportes;
	
	
	public RegistrarEnfermedad() {
		super("Registrar Usuario");
		iniciarGUI();
	}
		
		
	public void iniciarGUI(){
		
		/*--------------------------------------------------------------*/
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
		/*--------------------------------------------------------------*/
		
		
			panelImagen=new JPanel();
			panelImagen.setLayout(null);
			
			
			imagenLabel = new JLabel();
			imagenLabel.setBounds(160, 10, 300, 200);
			
		
			
			 ImageIcon imagen= new  ImageIcon(getClass().getResource("/imagenes/Farmacia2.png"));
		        Icon iconImagen = new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
		        imagenLabel.setIcon(iconImagen);
		        add(imagenLabel);
			
			
			
			panelImagen.add(imagenLabel);
			panelBot= new JPanel(new GridLayout(3, 2));
			
			add(panelImagen);
			add(panelBot, BorderLayout.PAGE_END);
			

			 nombre = new JLabel("NOMBRE :");
			 nombreEdit= new JTextField();
			 
			 
			 sintomas= new JLabel("SINTOMAS :");
			 sintomasEdit= new JTextField();
			 
			
			
			
			
			  atras= new JButton("ATRAS");
			  
			  botonNuevaEnfermedad= new JButton("REGISTRAR ENFERMEDAD");
			 
			
				
			panelBot.add(nombre);
			panelBot.add(nombreEdit);
			
			panelBot.add(sintomas);
			panelBot.add(sintomasEdit);
			
			
			
			
			panelBot.add(atras);
			panelBot.add(botonNuevaEnfermedad);
			
			botonNuevaEnfermedad.addActionListener(this);
			atras.addActionListener(this);
			
			
			pack();
			setSize(600,480);
			setLocationRelativeTo(null);
			setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String nombre,sintomas;
		
		
		
		
		if(e.getSource()==atras){
			
			MenuPrincipal m1= new MenuPrincipal();
			setVisible(false);
			
		}else if(e.getSource()==botonNuevaEnfermedad){
			
			nombre=nombreEdit.getText();
			sintomas=sintomasEdit.getText();
			
			
		
			
			try {
				boolean biencreado=controlador.RegistrarEnfermedad.Enfermedad(nombre, sintomas);

				
			
				if(biencreado==true){
					
					JOptionPane.showMessageDialog(this, "Los datos son correctos el pajaro se ha añadido a la base de datos","Registrado Correctamene",JOptionPane.INFORMATION_MESSAGE);
					MenuPrincipal m1= new MenuPrincipal();
					setVisible(false);
				}else{
					borrarDatos();
				
					JOptionPane.showMessageDialog(this, "No has introducido correctament el ID PAREJA o ID USUARIO","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				
			} catch (SQLException e1) {
				
				
			}
			

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
	
	public void borrarDatos(){
		
		nombreEdit.setText("");
		sintomasEdit.setText("");
		
		this.repaint();
		
	}

}
