package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	
	public Registrarse() {
		super("Registrar Usuario");
		iniciarGUI();
	}
		
		
	public void iniciarGUI(){
		
			panelImagen=new JPanel();
			panelImagen.setLayout(null);
			
			
			imagenLabel = new JLabel();
			imagenLabel.setBounds(160, 10, 300, 160);
			ponerImagen();
			
			
			panelImagen.add(imagenLabel);
			panelBot= new JPanel(new GridLayout(7, 2));
			
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
			
			panelBot.add(username);
			panelBot.add(usernameEdit);
			
			panelBot.add(contrasenya);
			panelBot.add(contrasenyaEdit);
			
			
			panelBot.add(borrarDatos);
			panelBot.add(botonNuevoUsuario);
			
			botonNuevoUsuario.addActionListener(this);
			
			
			pack();
			setSize(600,400);
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
			
			nombreEdit.setText("");
			apellidosEdit.setText("");
			edadEdit.setText("");
			correoEdit.setText("");
			telefonoEdit.setText("");
			usernameEdit.setText("");
			contrasenyaEdit.setText("");
			
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
			
			controlador.Registrarse.Registrarse(nom, ape, email, telf, edadPasar, user, passPasar);
			
			boolean bienCreado=controlador.Registrarse.comprobarRegistro(user, passPasar);
			
			if(bienCreado==true){
				
				JOptionPane.showMessageDialog(this, "Los datos son correctos el usuario se ha añadido a la base de datos","Registrado Correctamene",JOptionPane.INFORMATION_MESSAGE);
				MenuPrincipal m1= new MenuPrincipal();
			}else{
				contrasenyaEdit.setText("");
				usernameEdit.setText("");
				JOptionPane.showMessageDialog(this, "Ese usuario o esa contraseña son incorrectas","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			
			
			
		}
		
	}
	
	public  void ponerImagen(){
		/*String rutaImagen="imagen1.jpg";
		URL url= getClass().getResource(rutaImagen);
		ImageIcon imagen= new  ImageIcon(url);*/
		
		ImageIcon imagen= new  ImageIcon("usuario.jpg");
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

		


	