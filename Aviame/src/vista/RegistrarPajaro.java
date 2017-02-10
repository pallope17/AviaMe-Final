package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.print.DocFlavor.URL;
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

public class RegistrarPajaro extends JFrame implements ActionListener{
	

	JPanel panelBot,panelImagen;
	JTextField especieEdit,sexoEdit,colorEdit, observacionesEdit,idUsuarioEdit,idParejaEdit;
	JLabel especie,sexo,color,observaciones,id_usuario,id_pareja, imagenLabel;
	JButton botonNuevoPajaro,atras;
	private JMenuBar barra;
	private JMenu ayuda;
	private  JMenuItem salir, cerrarSesion,verAyuda,reportes;
	
	
	public RegistrarPajaro() {
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
			imagenLabel.setBounds(160, 10, 300, 190);
			
			 ImageIcon imagen= new  ImageIcon(getClass().getResource("/imagenes/imagen1.jpg"));
		        Icon iconImagen = new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
		        imagenLabel.setIcon(iconImagen);
		        add(imagenLabel);
			
			
			panelImagen.add(imagenLabel);
			panelBot= new JPanel(new GridLayout(8, 2));
			
			add(panelImagen);
			add(panelBot, BorderLayout.PAGE_END);
			

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
			  
			  botonNuevoPajaro= new JButton("REGISTRAR PAJARO");
			 
			
				
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
			
			
			panelBot.add(atras);
			panelBot.add(botonNuevoPajaro);
			
			botonNuevoPajaro.addActionListener(this);
			atras.addActionListener(this);
			
			
			pack();
			setSize(600,480);
			setLocationRelativeTo(null);
		
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String especie,sexo,color,observaciones;
		String idUsuario;
		String idPareja;
		int id_usuario,id_pareja;
		char[] pass;
		
		
		if(e.getSource()==atras){
			
			RegistrarModificarEliminarPajaro m1= new RegistrarModificarEliminarPajaro();
			setVisible(false);
			
		}else if(e.getSource()==botonNuevoPajaro){
			
			especie=especieEdit.getText();
			sexo=sexoEdit.getText();
			color=colorEdit.getText();
			observaciones=observacionesEdit.getText();
			idUsuario=idUsuarioEdit.getText();
			idPareja=idParejaEdit.getText();
			
	
	
			try {
				boolean biencreado=controlador.RegistrarPajaro.Registrarse(especie, sexo, color, observaciones, idUsuario, idPareja);

				
			
				if(biencreado==true){
					
					JOptionPane.showMessageDialog(this, "Los datos son correctos el pajaro se ha añadido a la base de datos","Registrado Correctamene",JOptionPane.INFORMATION_MESSAGE);
					MenuPrincipal m1= new MenuPrincipal();
					setVisible(false);
				}else if(biencreado==false){
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
		
		especieEdit.setText("");
		sexoEdit.setText("");
		colorEdit.setText("");
		observacionesEdit.setText("");
		idUsuarioEdit.setText("");
		idParejaEdit.setText("");
		
		this.repaint();
		
	}

}
