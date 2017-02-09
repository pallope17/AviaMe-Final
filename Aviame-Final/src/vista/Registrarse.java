package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;



public class Registrarse extends JFrame implements  ActionListener{
	
	
	JPanel panelBot,panelImagen;
	JTextField nombreEdit,apellidosEdit,edadEdit, telefonoEdit,correoEdit,usernameEdit;
	JPasswordField contrasenyaEdit;
	JLabel nombre,apellidos,edad,telefono,correo,username,contrasenya, imagenLabel;
	JButton botonNuevoUsuario,borrarDatos;
	private JMenuBar barra;
	private JMenu ayuda;
	private  JMenuItem salir, cerrarSesion,verAyuda,reportes;
	
	
	public Registrarse() {
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
			
			/*
			ImageIcon icon = new ImageIcon(getClass().getResource("/imganes/imagen1.jpg"));
			ponerImagen(icon);*/
			
			
			ponerImagen();
			
			
			panelImagen.add(imagenLabel);
			panelBot= new JPanel(new GridLayout(8, 2));
			
			add(panelImagen);
			add(panelBot, BorderLayout.PAGE_END);
			

			 nombre= new JLabel("Nombre :");
			 nombreEdit= new JTextField();
			 
			 
			 apellidos= new JLabel("Apellidos :");
			 apellidosEdit= new JTextField();
			 
			 edad	= new JLabel("Edad :");
			 edadEdit= new JTextField();
		
			 telefono= new JLabel("Teléfono :");
			 telefonoEdit= new JTextField();
			 
			 correo= new JLabel("Correo-electronico :");
			 correoEdit= new JTextField();
			 
			 username=new JLabel("Username :");
			 usernameEdit=new  JTextField();
			 
			 contrasenya= new JLabel("Contraseña :");
			 contrasenyaEdit=new JPasswordField();
			
			  borrarDatos= new JButton("Borrar Datos");
			  
			 botonNuevoUsuario= new JButton("Registrar Usuario");
			 
			
				
			panelBot.add(nombre);
			panelBot.add(nombreEdit);
			
			panelBot.add(apellidos);
			panelBot.add(apellidosEdit);
			
			panelBot.add(edad);
			panelBot.add(edadEdit);
			
			panelBot.add(correo);
			panelBot.add(correoEdit);
			
			panelBot.add(telefono);
			panelBot.add(telefonoEdit);
			
			panelBot.add(username);
			panelBot.add(usernameEdit);
			
			panelBot.add(contrasenya);
			panelBot.add(contrasenyaEdit);
			
			
			panelBot.add(borrarDatos);
			panelBot.add(botonNuevoUsuario);
			
			botonNuevoUsuario.addActionListener(this);
			borrarDatos.addActionListener(this);
			
			
			pack();
			setSize(600,480);
			setLocationRelativeTo(null);
		
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String nom,ape,email,telf,user,anyos,passPasar;
		int edadPasar;
		char[] pass;
		
		
		if(e.getSource()==borrarDatos){
			
			borrarDatos();
			
		}else if(e.getSource()==botonNuevoUsuario){
			
			nom=nombreEdit.getText();
			ape=apellidosEdit.getText();
			email=correoEdit.getText();
			telf=telefonoEdit.getText();
			user=usernameEdit.getText();
			pass=contrasenyaEdit.getPassword();
			anyos=edadEdit.getText();
			
			edadPasar=Integer.parseInt(anyos);
			passPasar=String.valueOf(pass); 
			
			try {
<<<<<<< HEAD:Aviame/src/vista/Registrarse.java
				controlador.Registrarse.Registrarse(nom, ape, email, telf, edadPasar, user, passPasar);

				boolean bienCreado = false;
				bienCreado = controlador.Registrarse.comprobarRegistro( passPasar);
		
				if(bienCreado==true){
					
					JOptionPane.showMessageDialog(this, "Los datos son correctos el usuario se ha añadido a la base de datos","Registrado Correctamene",JOptionPane.INFORMATION_MESSAGE);
					MenuPrincipal m1= new MenuPrincipal();
					setVisible(false);
				}else{
					nombreEdit.setText("");
					apellidosEdit.setText("");
					correoEdit.setText("");
					telefonoEdit.setText("");
					usernameEdit.setText("");
					contrasenyaEdit.setText("");
					edadEdit.setText("");
					JOptionPane.showMessageDialog(this, "Ya existe un usuario con este usuario","Error",JOptionPane.INFORMATION_MESSAGE);
=======
				
				System.out.println("antes del metodo");
				boolean bienCreado =controlador.Registrarse.Registrarse(nom, ape, email, telf, edadPasar, user, passPasar);

				
			
				System.out.println("despues del metodo");
				if(bienCreado==true){
					System.out.println("si el metodo es true");
					JOptionPane.showMessageDialog(this, "Los datos son correctos el usuario se ha añadido a la base de datos","Registrado Correctamene",JOptionPane.INFORMATION_MESSAGE);
					MenuPrincipal m1= new MenuPrincipal();
					setVisible(false);
				}else if(bienCreado==false){
					System.out.println("si el metodo es false");
				borrarDatos();
					JOptionPane.showMessageDialog(this, "Ya existe un usuario con este username","Error",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> dd319040b61bf515821afb2264af125f118e725f:Aviame-Final/src/vista/Registrarse.java
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
	
	public  void ponerImagen(){
		/*
		Image img=icon.getImage();
		Image icono= img.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon imagenFinal=	new ImageIcon(icono);
		imagenLabel.setIcon(imagenFinal);
		this.repaint();*/
		
		
		/*String rutaImagen="imagen1.jpg";
		URL url= getClass().getResource(rutaImagen);
		ImageIcon imagen= new  ImageIcon(url);*/
		
		ImageIcon imagen= new  ImageIcon("imagenes/usuario.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
		imagenLabel.setIcon(icono);
		this.repaint();
		
	}
	
	public void borrarDatos(){
		
		nombreEdit.setText("");
		apellidosEdit.setText("");
		edadEdit.setText("");
		correoEdit.setText("");
		telefonoEdit.setText("");
		usernameEdit.setText("");
		contrasenyaEdit.setText("");
		this.repaint();
		
	}


}

		


	