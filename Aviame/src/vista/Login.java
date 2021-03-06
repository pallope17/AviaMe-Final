package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener {
	
	private String usuario,contraseņa;
	private JLabel contraseņaLabel, usuarioLabel;
	private JTextField  usuarioField;
	private JPasswordField contraseņaField;
	private JButton iniciar, registrar;
	private JPanel panel;
	
	private boolean inicio;
	
	public Login(){
		
		iniciarGUI();
	}
	
	public void iniciarGUI(){
		
		panel= new JPanel();
		panel.setLayout(null);
		
		contraseņaField= new JPasswordField("");
		usuarioField=new JTextField("");
		
		contraseņaLabel= new JLabel("CONTRASEŅA:");
		usuarioLabel= new JLabel("USUARIO");
		
		usuarioLabel.setBounds(40,20,100,20);
	
		usuarioField.setBounds(120,20,120,20);
		
		contraseņaLabel.setBounds(40, 60, 100, 20);

		contraseņaField.setBounds(130, 60, 110, 20);

		
		iniciar= new JButton("Iniciar Sesion");
		registrar= new JButton("Registrarse");
		
		iniciar.setBounds(35,95,118,20);
		registrar.setBounds(160,95,110,20);
		
		iniciar.addActionListener(this);
		registrar.addActionListener(this);
	
	
		

		panel.add(usuarioField);
		panel.add(usuarioLabel);
		panel.add(contraseņaField);
		panel.add(contraseņaLabel);
		panel.add(iniciar);
		panel.add(registrar);
		
		add(panel);
		
		//add(contraseņaLabel);
		//add(contraseņaField);
		
		pack();
		setSize(300,160);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Iniciar Sesion");
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==iniciar){
			
			contraseņa=contraseņaField.getText();
			usuario=usuarioField.getText();
			
			try {
				inicio=controlador.Login.iniciarSesion(usuario,contraseņa);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		
			
			if(inicio==true){
				setVisible(false);
				JOptionPane.showMessageDialog(this, "Los datos coinciden ahora iras al menu principal","Has Iniciado Sesion",JOptionPane.INFORMATION_MESSAGE);
				MenuPrincipal m1= new MenuPrincipal();
				
			}else if(inicio==false){
				contraseņaField.setText("");
				usuarioField.setText("");
				JOptionPane.showMessageDialog(this, "Ese usuario o esa contraseņa son incorrectas","Error",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		else if(e.getSource()==registrar){
			setVisible(false);
			Registrarse regis1=new Registrarse();
		}
		
		
	}
	
}
